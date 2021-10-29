package com.waymap.o2o.cloud.provider.amazon.ad.nsEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author blue
 * @description NS 亚马逊广告 For Sponsored Products （recordType=productads） 报表
 * @email blue.liu@waymap.cn
 * @date 2019/11/1
 */
@Data
public class NSSpProductadsReport {
    //就叫id好像会和NS冲突，保存的时候报CUSTOM_RECORD_COLLISION
    @JSONField(name = "report_id")
    private Integer id;
    @JSONField(name = "custrecord_pro_ad_impressions")
    private String impressions;
    @JSONField(name = "custrecord_pro_ad_clicks")
    private String clicks;
    @JSONField(name = "custrecord_pro_ad_7_day_total_sales_")
    private String attributedSales7d;
    @JSONField(name = "custrecord_pro_ad_7_day_total_orders____")
    private String attributedConversions7d;
    @JSONField(name = "custrecord_pro_ad_currency")
    private String currency;
    @JSONField(name = "custrecord_pro_ad_advertised_sku")
    private String sku;
    @JSONField(name = "custrecord_pro_ad_7_day_advertised_sku_u")
    private String attributedUnitsOrdered7dSameSKU;
    @JSONField(name = "custrecord_pro_ad_spend")
    private String cost;
    @JSONField(name = "custrecord_pro_ad_ad_group_name")
    private String adGroupName;
    @JSONField(name = "custrecord_pro_ad_7_day_total_units____")
    private String attributedUnitsOrdered7d;
    @JSONField(name = "custrecord_pro_ad_7_day_advertised_sku_s")
    private String attributedSales7dSameSKU;
    @JSONField(name = "custrecord_pro_ad_advertised_asin")
    private String asin;
    @JSONField(name = "custrecord_pro_ad_campaign_name")
    private String campaignName;

    @JSONField(name = "custrecord_pro_ad_date")
    private String date;
    @JSONField(name = "custrecord_month")
    private String month;
//
//
//
//    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    private LocalDateTime orderCreateTime;
//    @JSONField(name = "firstname")
//    private String firstName;
}
