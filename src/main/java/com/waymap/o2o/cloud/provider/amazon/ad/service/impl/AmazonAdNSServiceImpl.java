package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.waymap.o2o.cloud.common.base.utils.JsonResult;
import com.waymap.o2o.cloud.common.base.utils.NSParam;
import com.waymap.o2o.cloud.provider.amazon.ad.bo.NsAmazonAdBO;
import com.waymap.o2o.cloud.provider.amazon.ad.vo.NsAmazonAdVO;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.*;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.*;
import com.waymap.o2o.cloud.provider.amazon.ad.nsEntity.NSHsaKeywordsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.nsEntity.NSSpProductadsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.service.*;
import com.waymap.o2o.cloud.provider.amazon.ad.utils.AmazonAdUtil;
import com.waymap.o2o.cloud.provider.amazon.ad.utils.MyExecutorFactory;
import com.waymap.o2o.cloud.provider.amazon.ad.utils.convert.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/**
 * @author blue&byte
 * @description NS service impl
 * @email blue.liu@waymap.cn
 * @date 2019/11/1&2021/9/14
 */
@Service("amazonAdNSService")
@Slf4j
public class AmazonAdNSServiceImpl implements AmazonAdNSService {
    @Resource
    private AmazonAdInformationService amazonAdInformationService;
    @Resource
    private AmazonAdReportSettingMapper amazonAdReportSettingMapper;
    @Resource
    private SpProductadsReportService spProductadsReportService;
    @Resource
    private HsaKeywordsReportService hsaKeywordsReportService;
    @Resource
    private SpCampaignsPlacementReportService spCampaignsPlacementReportService;
    @Resource
    private SpKeywordsQueryReportService spKeywordsQueryReportService;
    @Resource
    private IAccountsService accountsService;
    @Resource
    private AmazonAdAPIService amazonAdAPIService;

    @Override
    public void reportPush() {
        List<AmazonAdInformation> amazonAdInformationList = amazonAdInformationService.availableInformationList();
        ExecutorService executor = MyExecutorFactory.createExecutor(amazonAdInformationList.size(), "amazon-ad-ns-%d");
        CompletableFuture[] completableFutures = amazonAdInformationList.stream().map(
                amazonAdInformation -> CompletableFuture.runAsync(
                        () -> executeReportPush(amazonAdInformation), executor)).
                toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();

        MyExecutorFactory.shutDownPool(executor, 60);
}

    @Override
    public NsAmazonAdVO reportPull(NsAmazonAdBO nsAmazonAdBO) {
        NsAmazonAdVO nsAmazonAdVO = amazonAdAPIService.searchReport(nsAmazonAdBO);
        return  nsAmazonAdVO;
    }

    public void executeReportPush(AmazonAdInformation amazonAdInformation) {
        String accountId = amazonAdInformation.getAccountId();
        log.info("******** 推送亚马逊广告报表任务开始，accountId={} ********", accountId);
        List<AmazonAdReportSetting> amazonAdReportSettingList = amazonAdReportSettingMapper.getAvailableReportSetting(amazonAdInformation.getId());
        Map<String, Object> map = new HashMap<>(2);
        map.put("accountId", accountId);
        //后期可改成多线程跑
        for (AmazonAdReportSetting amazonAdReportSetting : amazonAdReportSettingList) {
            switch (AmazonAdUtil.AmazonAdReportType.getName(amazonAdReportSetting.getReportType())) {
                case SP_PRODUCTADS_REPORT:
                    List<SpProductadsReport> spProductadsReportList = spProductadsReportService.getFailureOrdersByAccountId(map);
                    List<NSSpProductadsReport> nsSpProductadsReportList = SpProductadsReportConvert.dbToNsEntity(spProductadsReportList);
                    ConcurrentLinkedQueue<SpProductadsReport> spProductadsNsResultQueue = doPush(accountId, amazonAdReportSetting, nsSpProductadsReportList);
                    if (spProductadsNsResultQueue == null || spProductadsNsResultQueue.isEmpty()) {
                        continue;
                    }

                    // 批量更新
                    List<SpProductadsReport> spProductadsNsResultList = new ArrayList<>(spProductadsNsResultQueue);
                    spProductadsReportService.updateBatchById(spProductadsNsResultList);
                    break;
                case SB_KEYWORDS_REPORT:
                    List<HsaKeywordsReport> hsaKeywordsReportList = hsaKeywordsReportService.getFailureOrdersByAccountId(map);
                    List<NSHsaKeywordsReport> nsHsaKeywordsReportList = HsaKeywordsReportConvert.dbToNsEntity(hsaKeywordsReportList);
                    ConcurrentLinkedQueue<HsaKeywordsReport> hsaKeywordsNsResultQueue = doPush(accountId, amazonAdReportSetting, nsHsaKeywordsReportList);
                    if (hsaKeywordsNsResultQueue == null || hsaKeywordsNsResultQueue.isEmpty()) {
                        continue;
                    }
                    // 批量更新
                    List<HsaKeywordsReport> hsaKeywordsNsResultList = new ArrayList<>(hsaKeywordsNsResultQueue);
                    hsaKeywordsReportService.updateBatchById(hsaKeywordsNsResultList);
                    break;
//                case SP_CAMPAIGNS_PLACEMENT_REPORT:
//                    List<SpCampaignsPlacementReport> spCampaignsPlacementReportList = spCampaignsPlacementReportService.getFailureOrdersByAccountId(map);
//                    List<NSSpCampaignsPlacementReport> nsSpCampaignsPlacementReportList = SpCampaignsPlacementReportConvert.dbToNsEntity(spCampaignsPlacementReportList);
//                    ConcurrentLinkedQueue<SpCampaignsPlacementReport> spCampaignsPlacementNsResultQueue = doPush(accountId, amazonAdReportSetting, nsSpCampaignsPlacementReportList);
//                    if (spCampaignsPlacementNsResultQueue == null || spCampaignsPlacementNsResultQueue.isEmpty()) {
//                        continue;
//                    }
//                    // 批量更新
//                    List<SpCampaignsPlacementReport> spCampaignsPlacementNsResultList = new ArrayList<>(spCampaignsPlacementNsResultQueue);
//                    spCampaignsPlacementReportService.updateBatchById(spCampaignsPlacementNsResultList);
//                    break;
//                case SP_KEYWORDS_QUERY_REPORT:
//                    List<SpKeywordsQueryReport> spKeywordsQueryReportList = spKeywordsQueryReportService.getFailureOrdersByAccountId(map);
//                    List<NSSpKeywordsQueryReport> nsSpKeywordsQueryReportList = SpKeywordsQueryReportConvert.dbToNsEntity(spKeywordsQueryReportList);
//                    ConcurrentLinkedQueue<SpKeywordsQueryReport> spKeywordsQueryNsResultQueue = doPush(accountId, amazonAdReportSetting, nsSpKeywordsQueryReportList);
//                    if (spKeywordsQueryNsResultQueue == null || spKeywordsQueryNsResultQueue.isEmpty()) {
//                        continue;
//                    }
//                    // 批量更新
//                    List<SpKeywordsQueryReport> spKeywordsQueryNsResultList = new ArrayList<>(spKeywordsQueryNsResultQueue);
//                    spKeywordsQueryReportService.updateBatchById(spKeywordsQueryNsResultList);
//                    break;
                default:
            }
        }
        log.info("********** 亚马逊广告报表推送结束 **********");
    }

    private <T, E> ConcurrentLinkedQueue<E> doPush(String accountId, AmazonAdReportSetting amazonAdReportSetting, List<T> reportList) {
        if (reportList.isEmpty()) {
            log.info("********** 没有需要推送的报表 *********" + amazonAdReportSetting);
            return null;
        }
        NSParam param = new NSParam(accountId, AmazonAdUtil.ScriptName.SAVE_AMAZON_AD_REPORT_REST);
        Integer scriptThread = accountsService.getScriptThread(param).getData();
        ConcurrentLinkedQueue<List<T>> list = new ConcurrentLinkedQueue<>(splitList(reportList, AmazonAdUtil.PUSH_LIMIT));
        ConcurrentLinkedQueue<E> nsResultList = new ConcurrentLinkedQueue<>();
        ExecutorService executor = MyExecutorFactory.createExecutor(scriptThread, "report-push-%d");

        String type = amazonAdReportSetting.getReportType();
        Instant startTime = Instant.now();
        //实际的pushToNS执行的很快，但是返回后要等待很久，应该是addAll操作的问题。考虑到线程安全暂不做处理，后期再做优化
        CompletableFuture[] completableFutures = list.stream().
                map(sublist -> CompletableFuture.supplyAsync(() -> this.pushToNS(accountId, sublist, type), executor).
                        whenComplete((s, e) -> nsResultList.addAll((Collection<? extends E>) s))).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();
        log.info("********** 推送用时：" + Duration.between(startTime, Instant.now()).getSeconds() + "秒 **********");
        return nsResultList;
    }

    /**
     * @MethodName: pushToNS
     * @Description: 推送亚马逊广告报表至NetSuite
     * @Param: [accountId, reportList]
     * @Return: java.utils.concurrent.ConcurrentLinkedQueue<com.waymap.o2o.cloud.common.base.utils.NSResult>
     * @Author: blue
     * @Date: 2019/11/1
     **/
    private <T, E> ConcurrentLinkedQueue<E> pushToNS(String accountId, List<T> reportList, String type) {
        // 组装json数据
        NSParam param = new NSParam(accountId, AmazonAdUtil.ScriptName.SAVE_AMAZON_AD_REPORT_REST);
        ConcurrentLinkedQueue<E> nsResultList = new ConcurrentLinkedQueue<>();
        if (reportList.size() == 0) {
            return nsResultList;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reportType", type);
        jsonObject.put("reportList", reportList);
        param.setJsonData(jsonObject.toJSONString());
        JsonResult<String> result = accountsService.requestNetSuite(param);
        if (result.isSuccess()) {
            try {
                // 添加所有运行结果
                nsResultList.addAll((Collection<? extends E>) JSONObject.parseArray(result.getData()));
            } catch (Exception e) {
                log.error("NS response error ： {}", result.getMessage());
            }
        } else {
            log.error("NS response error ： {}", JSON.toJSONString(result));
        }
        return nsResultList;
    }

    /**
     * 将一组数据平均分成n组
     *
     * @param source 要分组的数据源
     * @param n      平均分成n组
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

    /**
     * 将一组数据固定分组，每组n个元素
     *
     * @param source 要分组的数据源
     * @param n      每组n个元素
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> source, int n) {
        if (null == source || source.size() == 0 || n <= 0) {
            return new ArrayList<List<T>>();
        }
        List<List<T>> result = new ArrayList<List<T>>();
        int sourceSize = source.size();
        int size = (source.size() / n) + 1;
        for (int i = 0; i < size; i++) {
            List<T> subset = new ArrayList<T>();
            for (int j = i * n; j < (i + 1) * n; j++) {
                if (j < sourceSize) {
                    subset.add(source.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }
}
