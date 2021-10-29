package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpKeywordsQueryReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport;

import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Products（recordType=keywords;segment=query[search term]） 报表 service
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
public interface SpKeywordsQueryReportService extends IService<SpKeywordsQueryReport> {
    void insertOrUpdateBatch(List<SpKeywordsQueryReport> spKeywordsQueryReportList);
    /**
     * @MethodName: getFailureOrdersByAccountId
     * @Description: 根据accountId查询出推送失败的记录列表
     * @Param: [map]
     * @Return: java.utils.List<com.waymap.o2o.cloud.provider.amazon.ad.entity.SpKeywordsQueryReport>
     * @Author: blue
     * @Date: 2019/11/1
     **/
    List<SpKeywordsQueryReport> getFailureOrdersByAccountId(Map<String, Object> map);

}
