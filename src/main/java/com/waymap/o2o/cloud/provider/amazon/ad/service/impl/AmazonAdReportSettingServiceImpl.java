package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.AmazonAdInformationMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.AmazonAdReportSettingMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdInformation;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdInformationService;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdReportSettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author blue
 * @description 亚马逊广告报表抓取配置 service impl
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
@Service(value = "amazonAdReportSettingService")
public class AmazonAdReportSettingServiceImpl extends ServiceImpl<AmazonAdReportSettingMapper, AmazonAdReportSetting> implements AmazonAdReportSettingService {
    @Resource
    AmazonAdReportSettingMapper amazonAdReportSettingMapper;

    @Override
    public List<AmazonAdReportSetting> getAvailableReportSetting(Integer informationId) {
        return amazonAdReportSettingMapper.getAvailableReportSetting(informationId);
    }
}
