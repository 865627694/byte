package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.waymap.o2o.cloud.provider.amazon.ad.bo.NsAmazonAdBO;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.*;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.*;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdAPIService;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdInformationService;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdReportIdService;
import com.waymap.o2o.cloud.provider.amazon.ad.utils.AmazonAdHttpUtil;
import com.waymap.o2o.cloud.provider.amazon.ad.utils.FileUtil;
import com.waymap.o2o.cloud.provider.amazon.ad.utils.MyExecutorFactory;
import com.waymap.o2o.cloud.provider.amazon.ad.vo.NsAmazonAdVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * @author blue&byte
 * @description 亚马逊广告API服务 impl
 * @email blue.liu@waymap.cn
 * @date 2019/10/28&2021/9/13
 */

@Service("amazonAdAPIService")
@Slf4j
public class AmazonAdAPIServiceImpl implements AmazonAdAPIService {
    @Resource
    private AmazonAdInformationService amazonAdInformationService;
    @Resource
    private AmazonAdReportSettingMapper amazonAdReportSettingMapper;
    @Resource
    private AmazonAdReportMapper amazonAdReportMapper;
    @Resource
    private AmazonAdReportIdService amazonAdReportIdService;

    @Override
    public void reportGet() {
        List<AmazonAdInformation> amazonAdInformationList = amazonAdInformationService.availableInformationList();
        ExecutorService executor = MyExecutorFactory.createExecutor(amazonAdInformationList.size(), "amazon-ad-api-%d");
        CompletableFuture[] completableFutures = amazonAdInformationList.stream().map(
                amazonAdInformation -> CompletableFuture.supplyAsync(
                        () -> executeReportGet(amazonAdInformation), executor)).
                toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();
        MyExecutorFactory.shutDownPool(executor, 60);
    }

    @Override
    public void reportDownload() {
        List<AmazonAdInformation> amazonAdInformationList = amazonAdInformationService.availableInformationList();

        ExecutorService executor = MyExecutorFactory.createExecutor(amazonAdInformationList.size(), "amazon-ad-api-%d");
        CompletableFuture[] completableFutures = amazonAdInformationList.stream().map(
                amazonAdInformation -> CompletableFuture.supplyAsync(
                        () -> executeReportDownload(amazonAdInformation), executor)).
                toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();

        MyExecutorFactory.shutDownPool(executor, 60);
}

    public JSONObject executeReportDownload(AmazonAdInformation amazonAdInformation) {
        // 保存执行日志
        JSONObject logMap = new JSONObject();
        try {
            log.info("******** 下载亚马逊广告报表任务开始，accountId={} ********", amazonAdInformation.getAccountId());
            List<AmazonAdReportId> amazonAdReportIdList = amazonAdReportIdService.searchReportId(amazonAdInformation.getId());
            //批量下载报告
            for (AmazonAdReportId amazonAdReportId : amazonAdReportIdList) {
                String reportJson = AmazonAdHttpUtil.doAmazonAdGetJsonInGz(amazonAdInformation, amazonAdReportId.getProfile(), amazonAdReportId.getReportId());
                if (reportJson == null) {
                    log.error("报表生成失败：" + amazonAdReportId);
                    continue;
                }
                //TODO 将报告保存在本地，数据库只存文件路径
                //将文件存在系统临时文件夹
                File file = File.createTempFile("AmazonAdsReportData" + amazonAdReportId.getId(), ".txt");
//                File file = new File("./reportData/"+amazonAdReportId.getId());
                FileUtil.writeStringToFile(file, reportJson, "UTF-8", false);
                String filePath = file.toString();
                //直接存入数据库
                //构造entity
                AmazonAdReport amazonAdReport = getAmazonAdReport(amazonAdInformation, amazonAdReportId.getReportDate(), amazonAdReportId, filePath);
                amazonAdReportIdService.downloadReport(amazonAdReport);
            }
            log.info("******** 下载亚马逊广告报表结束，accountId={} ********", amazonAdInformation.getAccountId());
        } catch (Exception e) {
            logMap.put("error", e);
            e.printStackTrace();
        }
        return logMap;
    }

    //将保存在数据库里面的报表查出来
    @Override
    public NsAmazonAdVO searchReport(NsAmazonAdBO nsAmazonAdBO) {
        NsAmazonAdVO nsAmazonAdVO = amazonAdReportMapper.getReport(nsAmazonAdBO);
        File file = new File("" + nsAmazonAdVO.getContent());
        try {
            String content = FileUtil.readFileToString(file, "UTF-8");
            nsAmazonAdVO.setContent(content);
            return nsAmazonAdVO;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject executeReportGet(AmazonAdInformation amazonAdInformation) {
        // 保存执行日志
        JSONObject logMap = new JSONObject();
        try {
            log.info("******** 请求亚马逊广告报表ID任务开始，accountId={} ********", amazonAdInformation.getAccountId());
            //刷新token
            String accessToken = AmazonAdHttpUtil.refreshTokenPost(amazonAdInformation);
            amazonAdInformation.setAccessToken(accessToken);
            //取昨天的报表
            LocalDateTime startDate = LocalDateTime.now().minusDays(1);
            String reportDate = startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            logMap.put("startDate", reportDate);
            logMap.put("accountId", amazonAdInformation.getAccountId());
            List<AmazonAdReportSetting> amazonAdReportSettingList = amazonAdReportSettingMapper.getAvailableReportSetting(amazonAdInformation.getId());
            //后期可改成多线程跑

            //批量生成reportId
            for (AmazonAdReportSetting amazonAdReportSetting : amazonAdReportSettingList) {
                String reportId = AmazonAdHttpUtil.getAmazonAdReportId(amazonAdInformation, amazonAdReportSetting, reportDate);
                if (reportId == null) {
                    log.error("报表id请求失败：" + amazonAdReportSetting);
                    continue;
                }
                log.info("reportId：" + reportId + "recordType:" + amazonAdReportSetting.getReportType() + "reportType:" + amazonAdReportSetting.getReportType());
                //存入数据库
                AmazonAdReportId amazonAdReportId = new AmazonAdReportId();
                amazonAdReportId.setInternalId(amazonAdReportSetting.getInternalId());
                amazonAdReportId.setReportId(reportId);
                amazonAdReportId.setRecordType(amazonAdReportSetting.getRecordType());
                amazonAdReportId.setReportType(amazonAdReportSetting.getReportType());
                amazonAdReportId.setReportSetId(amazonAdReportSetting.getId());
                amazonAdReportId.setProfile(amazonAdReportSetting.getProfile());
                amazonAdReportId.setInformationId(amazonAdInformation.getId());
                amazonAdReportId.setReportDate(startDate);

                amazonAdReportIdService.saveReportId(amazonAdReportId);
            }
            log.info("******** 请求亚马逊广告报表Id结束，accountId={} ********", amazonAdInformation.getAccountId());
        } catch (Exception e) {
            logMap.put("error", e);
            e.printStackTrace();
        }
        return logMap;
    }


    private AmazonAdReport getAmazonAdReport(AmazonAdInformation amazonAdInformation, LocalDateTime startDate, AmazonAdReportId amazonAdReportId, String reportJson) {
        AmazonAdReport amazonAdReport = new AmazonAdReport();
        amazonAdReport.setReportSetId(amazonAdReportId.getReportSetId());
        amazonAdReport.setInternalId(amazonAdReportId.getInternalId());
        amazonAdReport.setInformationId(amazonAdInformation.getId());
        amazonAdReport.setProfile(amazonAdReportId.getProfile());
        amazonAdReport.setRecordType(amazonAdReportId.getRecordType());
        amazonAdReport.setReportType(amazonAdReportId.getReportType());
        amazonAdReport.setContent(reportJson);
        amazonAdReport.setReportDate(startDate);
        amazonAdReport.setCreateDate(LocalDateTime.now());
        amazonAdReport.setUpdateDate(LocalDateTime.now());
        return amazonAdReport;
    }

}
