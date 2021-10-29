package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpCampaignsPlacementReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpKeywordsQueryReport;

import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Products（recordType=campaigns;segment=placement[location]） 报表 service
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
public interface SpCampaignsPlacementReportService extends IService<SpCampaignsPlacementReport> {
    void insertOrUpdateBatch(List<SpCampaignsPlacementReport> spCampaignsPlacementReportList);
    /**
     * @MethodName: getFailureOrdersByAccountId
     * @Description: 根据accountId查询出推送失败的记录列表
     * @Param: [map]
     * @Return: java.utils.List<com.waymap.o2o.cloud.provider.amazon.ad.entity.SpCampaignsPlacementReport>
     * @Author: blue
     * @Date: 2019/11/1
     **/
    List<SpCampaignsPlacementReport> getFailureOrdersByAccountId(Map<String, Object> map);
}
