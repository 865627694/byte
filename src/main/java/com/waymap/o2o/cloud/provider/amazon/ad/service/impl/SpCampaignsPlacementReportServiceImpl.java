package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.SpCampaignsPlacementReportMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.SpProductadsReportMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpCampaignsPlacementReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.service.SpCampaignsPlacementReportService;
import com.waymap.o2o.cloud.provider.amazon.ad.service.SpProductadsReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Products（recordType=campaigns;segment=placement[location]） 报表 service impl
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
@Service(value = "spCampaignsPlacementReportService")
public class SpCampaignsPlacementReportServiceImpl extends ServiceImpl<SpCampaignsPlacementReportMapper, SpCampaignsPlacementReport> implements SpCampaignsPlacementReportService {
    @Resource
    SpCampaignsPlacementReportMapper spCampaignsPlacementReportMapper;

    @Override
    public void insertOrUpdateBatch(List<SpCampaignsPlacementReport> spCampaignsPlacementReportList) {
        spCampaignsPlacementReportMapper.insertOrUpdateBatch(spCampaignsPlacementReportList);
    }

    @Override
    public List<SpCampaignsPlacementReport> getFailureOrdersByAccountId(Map<String, Object> map) {
        return spCampaignsPlacementReportMapper.getFailureOrdersByAccountId(map);
    }
}
