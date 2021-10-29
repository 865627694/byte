package com.waymap.o2o.cloud.provider.amazon.ad.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdInformation;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author blue
 * @description 亚马逊广告报表抓取配置DAO
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
public interface AmazonAdReportSettingMapper extends BaseMapper<AmazonAdReportSetting> {

    /**
     * @MethodName: getAvailableReportSetting
     * @Description: 获取可用的亚马逊广告抓取配置
     * @Param: [informationId]
     * @Return: java.utils.List<com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting>
     * @Author: blue
     * @Date: 2019/10/28
     **/
    List<AmazonAdReportSetting> getAvailableReportSetting(@Param("informationId") Integer informationId);
}
