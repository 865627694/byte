package com.waymap.o2o.cloud.provider.amazon.ad.nsEntity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Products（recordType=campaigns;segment=placement[location]） 报表
 * @email blue.liu@waymap.cn
 * @date 2019/11/1
 */
@Data
public class NSSpCampaignsPlacementReport {
    //就叫id好像会和NS冲突，保存的时候报CUSTOM_RECORD_COLLISION
    @JSONField(name = "report_id")
    private Integer id;
    @JSONField(name = "custrecord_sspa_sp_impressions")
    private String impressions;
    @JSONField(name = "custrecord_sspa_sp_clicks")
    private String clicks;
    @JSONField(name = "custrecord_sspa_sp_7_day_total_sales_")
    private String attributedSales7d;
    @JSONField(name = "custrecord_sspa_sp_7_day_total_orders_")
    private String attributedConversions7d;
    @JSONField(name = "custrecord_sspa_sp_14_day_total_orders__")
    private String attributedConversions14d;
    @JSONField(name = "custrecord_sspa_sp_spend")
    private String cost;
    @JSONField(name = "custrecord_sspa_sp_7_day_total_units_")
    private String attributedUnitsOrdered7d;
    @JSONField(name = "custrecord_sspa_sp_placement")
    private String placement;
    @JSONField(name = "custrecord_sspa_sp_14_day_total_sales_sb")
    private String attributedSales14d;
    @JSONField(name = "custrecord_sspa_sp_campaign_name")
    private String campaignName;
    @JSONField(name = "custrecord_sspa_sp_14_day_total_units___")
    private String attributedUnitsOrdered14d;
    @JSONField(name = "custrecord_sspa_sp_campaign_status")
    private String campaignStatus;
    @JSONField(name = "custrecord_sspa_sp_campaignid")
    private String campaignId;
    @JSONField(name = "custrecord_sspa_sp_campaignbudget")
    private String campaignBudget;

    @JSONField(name = "custrecord_sspa_sp_date")
    private String date;
    @JSONField(name = "custrecord_sspa_sp_year")
    private String year;
    @JSONField(name = "custrecord_sspa_sp_month")
    private String month;

//    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    private LocalDateTime orderCreateTime;
//    @JSONField(name = "firstname")
//    private String firstName;
}
