package com.waymap.o2o.cloud.provider.amazon.ad.nsEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Brands （recordType=keywords） 报表
 * @email blue.liu@waymap.cn
 * @date 2019/11/1
 */
@Data
public class NSHsaKeywordsReport {
    //就叫id好像会和NS冲突，保存的时候报CUSTOM_RECORD_COLLISION
    @JSONField(name = "report_id")
    private Integer id;
    @JSONField(name = "custrecord_sp_br_impressions")
    private String impressions;
    @JSONField(name = "custrecord_sp_br_clicks")
    private String clicks;
    @JSONField(name = "custrecordcustrecord_sp_br_keywordid")
    private String keywordId;
    @JSONField(name = "custrecord_sp_br_match_type")
    private String matchType;
    @JSONField(name = "custrecord_sp_br_14_day___of_orders_new_")
    private String attributedOrdersNewToBrandPercentage14d;
    @JSONField(name = "custrecord_sp_br_adgroupid")
    private String adGroupId;
    @JSONField(name = "custrecord_sp_br_keywordbid")
    private String keywordBid;
    @JSONField(name = "custrecord_sp_br_keywordstatus")
    private String keywordStatus;
    @JSONField(name = "custrecord_sp_br_14_day_new_to_brand_ort")
    private String attributedOrderRateNewToBrand14d;
    @JSONField(name = "custrecord_sp_br_14_day_total_orders____")
    private String attributedConversions14d;
    @JSONField(name = "custrecord_sp_br_campaignstatus")
    private String campaignStatus;
    @JSONField(name = "custrecord_sp_br_14_day___of_sales_new_t")
    private String attributedSalesNewToBrandPercentage14d;
    @JSONField(name = "custrecord_sp_br_14_day___of_units_new_t")
    private String attributedUnitsOrderedNewToBrandPercentage14d;
    @JSONField(name = "custrecord_sp_br_14_day_new_to_brand_sal")
    private String attributedSalesNewToBrand14d;
    @JSONField(name = "custrecord_sp_br_spend")
    private String cost;
    @JSONField(name = "custrecord_sp_br_targeting")
    private String keywordText;
    @JSONField(name = "custrecord_sp_br_campaignbudget")
    private String campaignBudget;
    @JSONField(name = "custrecord_sp_br_14_day_total_units____")
    private String unitsSold14d;
    @JSONField(name = "custrecord_sp_br_14_day_new_to_brand_ord")
    private String attributedOrdersNewToBrand14d;
    @JSONField(name = "custrecord_sp_br_14_day___of_units_new_t")
    private String attributedUnitsOrderedNewToBrand14d;
    @JSONField(name = "custrecord_sp_br_14_day_total_sales_")
    private String attributedSales14d;
    @JSONField(name = "custrecord_sp_br_campaign_name")
    private String campaignName;

    @JSONField(name = "custrecord_sp_br_date")
    private String date;



//    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    private LocalDateTime orderCreateTime;
//    @JSONField(name = "firstname")
//    private String firstName;
}
