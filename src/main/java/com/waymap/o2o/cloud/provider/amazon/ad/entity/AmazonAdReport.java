package com.waymap.o2o.cloud.provider.amazon.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * 亚马逊广告
 *
 * @author Byte on 2021/9/13
 */
@TableName("o2o_amazon_ad_report")
@Data
public class AmazonAdReport {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * o2o_amazon_ad_report_set id
     */
    private Integer reportSetId;
    /**
     * information_id,店铺ID
     */
    private Integer informationId;
    /**
     * 亚马逊广告 profile，header中的Amazon-Advertising-API-Scope值
     */
    private String profile;
    /**
     * 亚马逊广告 internal_id
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
     * JSON字符串，报表的所有信息
     */
    private String content;
    /**
     * 报表日期
     */
    private LocalDateTime reportDate;
    /**
     * 记录创建时间
     */
    private LocalDateTime createDate;
    /**
     * 记录修改时间
     */
    private LocalDateTime updateDate;
    /**
     * ns 内部id
     */
    private String nsInternalId;
    /**
     * 推送成败
     */
    private Boolean success;
    /**
     * 推送结果
     */
    private String message;
}
