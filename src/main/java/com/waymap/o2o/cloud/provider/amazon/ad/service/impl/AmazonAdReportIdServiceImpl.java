package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.waymap.o2o.cloud.provider.amazon.ad.bo.NsAmazonAdBO;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.AmazonAdReportIdMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.AmazonAdReportMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportId;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdReportIdService;
import com.waymap.o2o.cloud.provider.amazon.ad.vo.NsAmazonAdVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 亚马逊广告报告Id
 *
 * @author YinFuCheng on 2021/9/22
 */
@Service("AmazonAdReportIdService")
@Slf4j
public class AmazonAdReportIdServiceImpl implements AmazonAdReportIdService {
    @Resource
    AmazonAdReportIdMapper amazonAdReportIdMapper;
    @Resource
    AmazonAdReportMapper amazonAdReportMapper;

    @Override
    public synchronized void saveReportId(AmazonAdReportId amazonAdReportId) {
        amazonAdReportIdMapper.insertReportId(amazonAdReportId);
    }

    @Override
    public List<AmazonAdReportId> searchReportId(Integer id) {
        List<AmazonAdReportId> amazonAdReportIdList = amazonAdReportIdMapper.searchReportId(id);
        return amazonAdReportIdList;
    }

    @Override
    public synchronized void downloadReport(AmazonAdReport amazonAdReport) {
        amazonAdReportMapper.insertOrUpdateBatch(amazonAdReport);
    }
}