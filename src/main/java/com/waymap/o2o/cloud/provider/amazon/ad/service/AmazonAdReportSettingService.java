package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdInformation;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting;

import java.util.List;

/**
 * @author blue
 * @description 亚马逊广告报表抓取配置 service
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
public interface AmazonAdReportSettingService extends IService<AmazonAdReportSetting> {
    /**
     * @MethodName: getAvailableReportSetting
     * @Description: 获取可用的亚马逊广告抓取配置
     * @Param: [informationId]
     * @Return: java.utils.List<com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting>
     * @Author: blue
     * @Date: 2019/10/28
     **/
    List<AmazonAdReportSetting> getAvailableReportSetting(Integer informationId);
}
