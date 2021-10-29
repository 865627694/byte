package com.waymap.o2o.cloud.provider.amazon.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 亚马逊广告报告reportId
 *
 * @author Byte on 2021/9/18
 */
@TableName("o2o_amazon_ad_report_id")
@Data
public class AmazonAdReportId {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * report_id
     */
    private String reportId;
    /**
     * internal_id 店铺名在ns对应的内部id
     */
    private String internalId;
    /**
     * 记录类型 SP,SB,SD
     */
    private String  recordType;
    /**
     * 报告类型：productADs,keyWord,ADGroup
     */
    private String reportType;
    /**
     * o2o_amazon_ad_report_set id
     */
    private Integer reportSetId;
    /**
     * 亚马逊广告 profile，header中的Amazon-Advertising-API-Scope值
     */
    private String profile;
    /**
     * 亚马逊广告 informationId，表o2o_amazon_ad_information id
     */
    private Integer informationId;
    /**
     * 亚马逊广告 reportDate,报表日期
     */
    private LocalDateTime reportDate;
}
