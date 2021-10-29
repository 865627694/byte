package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.waymap.o2o.cloud.provider.amazon.ad.bo.NsAmazonAdBO;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportId;
import com.waymap.o2o.cloud.provider.amazon.ad.vo.NsAmazonAdVO;

import java.util.List;

/**
 * @author byte
 * @description 亚马逊广告报告id
 * @date 2021/9/14
 */
public interface AmazonAdReportIdService {
    /**
     * 保存亚马逊广告报表Id，reportId
     */
    void saveReportId(AmazonAdReportId amazonAdReportId);

    /**
     * 查出亚马逊广告所有报表Id
     */
    List<AmazonAdReportId> searchReportId(Integer id);
    /**
     * 下载报告
     */
     void downloadReport (AmazonAdReport amazonAdReport);
}
