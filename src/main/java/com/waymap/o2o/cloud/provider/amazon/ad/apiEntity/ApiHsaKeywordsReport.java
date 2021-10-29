package com.waymap.o2o.cloud.provider.amazon.ad.apiEntity;

import lombok.Data;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Brands （recordType=keywords） 报表
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
@Data
public class ApiHsaKeywordsReport {
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

}
