package com.waymap.o2o.cloud.provider.amazon.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Products （recordType=productads） 报表
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
@Data
@TableName("o2o_amazon_ad_sp_productads_report")
public class SpProductadsReport {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private int id;
    /**
     * o2o_amazon_ad_report_set id
     */
    private int reportSetId;
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
    private boolean success;
    /**
     * 推送结果
     */
    private String message;

    private String campaignName;
    private String campaignId;
    private String adGroupName;
    private String adGroupId;
    private String impressions;
    private String clicks;
    private String cost;
    private String currency;
    private String asin;
    private String sku;
    private String attributedConversions1d;
    private String attributedConversions7d;
    private String attributedConversions14d;
    private String attributedConversions30d;
    private String attributedConversions1dSameSku;
    private String attributedConversions7dSameSku;
    private String attributedConversions14dSameSku;
    private String attributedConversions30dSameSku;
    private String attributedUnitsOrdered1d;
    private String attributedUnitsOrdered7d;
    private String attributedUnitsOrdered14d;
    private String attributedUnitsOrdered30d;
    private String attributedSales1d;
    private String attributedSales7d;
    private String attributedSales14d;
    private String attributedSales30d;
    private String attributedSales1dSameSku;
    private String attributedSales7dSameSku;
    private String attributedSales14dSameSku;
    private String attributedSales30dSameSku;
    private String attributedUnitsOrdered1dSameSku;
    private String attributedUnitsOrdered7dSameSku;
    private String attributedUnitsOrdered14dSameSku;
    private String attributedUnitsOrdered30dSameSku;
}
