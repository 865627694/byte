package com.waymap.o2o.cloud.provider.amazon.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Brands （recordType=keywords） 报表
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
@Data
@TableName("o2o_amazon_ad_hsa_keywords_report")
public class HsaKeywordsReport {
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
    private String campaignStatus;
    private String campaignBudget;
    private String campaignBudgetType;
    private String adGroupName;
    private String adGroupId;
    private String keywordText;
    private String keywordBid;
    private String keywordStatus;
    private String targetId;
    private String targetingExpression;
    private String targetingText;
    private String targetingType;
    private String matchType;
    private String impressions;
    private String clicks;
    private String cost;
    private String attributedDetailPageViewsClicks14d;
    private String attributedSales14d;
    private String attributedSales14dSameSku;
    private String attributedConversions14d;
    private String attributedConversions14dSameSku;
    private String attributedOrdersNewToBrand14d;
    private String attributedOrdersNewToBrandPercentage14d;
    private String attributedOrderRateNewToBrand14d;
    private String attributedSalesNewToBrand14d;
    private String attributedSalesNewToBrandPercentage14d;
    private String attributedUnitsOrderedNewToBrand14d;
    private String attributedUnitsOrderedNewToBrandPercentage14d;
    private String unitsSold14d;
    private String dpv14d;
}
