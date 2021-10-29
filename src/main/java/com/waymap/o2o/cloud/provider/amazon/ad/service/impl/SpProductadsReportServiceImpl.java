package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.AmazonAdReportSettingMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.SpProductadsReportMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdReportSettingService;
import com.waymap.o2o.cloud.provider.amazon.ad.service.SpProductadsReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 SP Productads 报表 service impl
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
@Service(value = "spProductadsReportService")
public class SpProductadsReportServiceImpl extends ServiceImpl<SpProductadsReportMapper, SpProductadsReport> implements SpProductadsReportService {
    @Resource
    SpProductadsReportMapper spProductadsReportMapper;

    @Override
    public void insertOrUpdateBatch(AmazonAdReport amazonAdReport) {
//        spProductadsReportMapper.insertOrUpdateBatch(amazonAdReport);
    }

    @Override
    public List<SpProductadsReport> getFailureOrdersByAccountId(Map<String, Object> map) {
        return spProductadsReportMapper.getFailureOrdersByAccountId(map);
    }
}
