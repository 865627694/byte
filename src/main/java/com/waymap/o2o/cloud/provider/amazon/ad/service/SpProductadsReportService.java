package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport;

import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 SP Productads 报表 Service
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
public interface SpProductadsReportService extends IService<SpProductadsReport> {
    void insertOrUpdateBatch(AmazonAdReport amazonAdReport);

    /**
     * @MethodName: getFailureOrdersByAccountId
     * @Description: 根据accountId查询出推送失败的记录列表
     * @Param: [map]
     * @Return: java.utils.List<com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport>
     * @Author: blue
     * @Date: 2019/11/1
     **/
    List<SpProductadsReport> getFailureOrdersByAccountId(Map<String, Object> map);
}
