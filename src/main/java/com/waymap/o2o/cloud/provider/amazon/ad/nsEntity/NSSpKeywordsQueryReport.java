package com.waymap.o2o.cloud.provider.amazon.ad.nsEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Products（recordType=keywords;segment=query[search term]） 报表
 * @email blue.liu@waymap.cn
 * @date 2019/11/1
 */
@Data
public class NSSpKeywordsQueryReport {
    //就叫id好像会和NS冲突，保存的时候报CUSTOM_RECORD_COLLISION
    @JSONField(name = "report_id")
    private Integer id;
    @JSONField(name = "custrecord_sspa_se_impressions")
    private String impressions;
    @JSONField(name = "custrecord_sspa_se_clicks")
    private String clicks;
    @JSONField(name = "custrecord_sspa_se_7_total_sales_")
    private String attributedSales7d;
    @JSONField(name = "custrecord_sspa_se_match_type")
    private String matchType;
    @JSONField(name = "custrecord_sspa_se_7_total_orders_")
    private String attributedConversions7d;
    @JSONField(name = "custrecord_sspa_se_7_advertised_sku_unit")
    private String attributedUnitsOrdered7dSameSKU;
    @JSONField(name = "custrecord_sspa_se_spend")
    private String cost;
    @JSONField(name = "custrecord_sspa_se_ad_group_name")
    private String adGroupName;
    @JSONField(name = "custrecord_sspa_se_7_total_units_")
    private String attributedUnitsOrdered7d;
    @JSONField(name = "custrecord_sspa_se_7_advertised_sku_sale")
    private String attributedSales7dSameSKU;
    @JSONField(name = "custrecord_sspa_se_customer_search_term")
    private String query;
    @JSONField(name = "custrecord_sspa_se_targeting")
    private String keywordText;
    @JSONField(name = "custrecord_sspa_se_campaign_name")
    private String campaignName;

    @JSONField(name = "custrecord_sspa_se_date")
    private String date;
    @JSONField(name = "custrecord_sspa_se_year")
    private String year;
    @JSONField(name = "custrecord_sspa_se_month")
    private String month;

//    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    private LocalDateTime orderCreateTime;
//    @JSONField(name = "firstname")
//    private String firstName;
}
