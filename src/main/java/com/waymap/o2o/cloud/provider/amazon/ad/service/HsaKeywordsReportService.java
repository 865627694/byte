package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.HsaKeywordsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpCampaignsPlacementReport;

import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Brands （recordType=keywords） 报表 service
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
public interface HsaKeywordsReportService extends IService<HsaKeywordsReport> {
    void insertOrUpdateBatch(List<HsaKeywordsReport> hsaKeywordsReportList);
    /**
     * @MethodName: getFailureOrdersByAccountId
     * @Description: 根据accountId查询出推送失败的记录列表
     * @Param: [map]
     * @Return: java.utils.List<com.waymap.o2o.cloud.provider.amazon.ad.entity.HsaKeywordsReport>
     * @Author: blue
     * @Date: 2019/11/1
     **/
    List<HsaKeywordsReport> getFailureOrdersByAccountId(Map<String, Object> map);
}
