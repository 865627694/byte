package com.waymap.o2o.cloud.provider.amazon.ad.dao;

import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportId;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AmazonAdReportIdMapper {
    /**
     * 插入报告id
     */
    void insertReportId(@Param("report") AmazonAdReportId amazonAdReportId);

    /**
     * 查出所有报告id
     * @return
     */
    List<AmazonAdReportId> searchReportId(Integer id);
}
