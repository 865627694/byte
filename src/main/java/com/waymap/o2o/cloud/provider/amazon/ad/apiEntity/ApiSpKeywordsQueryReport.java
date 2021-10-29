package com.waymap.o2o.cloud.provider.amazon.ad.apiEntity;

import lombok.Data;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Products（recordType=keywords;segment=query[search term]） 报表
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
@Data
public class ApiSpKeywordsQueryReport {
    private String campaignName;
    private String campaignId;
    private String adGroupName;
    private String adGroupId;
    private String keywordId;
    private String keywordText;
    private String matchType;
    private String impressions;
    private String clicks;
    private String cost;
    private String attributedConversions1d;
    private String attributedConversions7d;
    private String attributedConversions14d;
    private String attributedConversions30d;
    private String attributedConversions1dSameSKU;
    private String attributedConversions7dSameSKU;
    private String attributedConversions14dSameSKU;
    private String attributedConversions30dSameSKU;
    private String attributedUnitsOrdered1d;
    private String attributedUnitsOrdered7d;
    private String attributedUnitsOrdered14d;
    private String attributedUnitsOrdered30d;
    private String attributedSales1d;
    private String attributedSales7d;
    private String attributedSales14d;
    private String attributedSales30d;
    private String attributedSales1dSameSKU;
    private String attributedSales7dSameSKU;
    private String attributedSales14dSameSKU;
    private String attributedSales30dSameSKU;
    private String attributedUnitsOrdered1dSameSKU;
    private String attributedUnitsOrdered7dSameSKU;
    private String attributedUnitsOrdered14dSameSKU;
    private String attributedUnitsOrdered30dSameSKU;
    private String query;
}
