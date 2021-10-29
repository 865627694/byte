package com.waymap.o2o.cloud.provider.amazon.ad.dao;

import com.waymap.o2o.cloud.provider.amazon.ad.bo.NsAmazonAdBO;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReport;
import com.waymap.o2o.cloud.provider.amazon.ad.vo.NsAmazonAdVO;
import org.apache.ibatis.annotations.Param;


public interface AmazonAdReportMapper {
    /**
     * 插入报告
     * @param amazonAdReport
     */
      void  insertOrUpdateBatch(@Param("report") AmazonAdReport amazonAdReport);

    /**
     * 根据字段查询报告
     * @param nsAmazonAdBO
     * @return
     */
    NsAmazonAdVO getReport(NsAmazonAdBO nsAmazonAdBO);
}
