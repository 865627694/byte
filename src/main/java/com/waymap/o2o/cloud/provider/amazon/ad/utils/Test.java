package com.waymap.o2o.cloud.provider.amazon.ad.utils;

import com.alibaba.fastjson.JSON;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport;

import java.util.List;

/**
 * @author blue
 * @description TODO
 * @email blue.liu@waymap.cn
 * @date 2019/10/30
 */
public class Test {
    public static void main(String[] args) {
       String json="[{\n" +
               "  \"attributedUnitsOrdered1dSameSKU\": 0,\n" +
               "  \"attributedSales7d\": 0,\n" +
               "  \"attributedSales30d\": 0,\n" +
               "  \"attributedUnitsOrdered30d\": 0,\n" +
               "  \"attributedSales1d\": 0,\n" +
               "  \"attributedConversions1d\": 0,\n" +
               "  \"attributedSales1dSameSKU\": 0,\n" +
               "  \"attributedConversions30d\": 0,\n" +
               "  \"adGroupId\": 224699554566642,\n" +
               "  \"attributedConversions7d\": 0,\n" +
               "  \"attributedConversions14d\": 0,\n" +
               "  \"currency\": \"USD\",\n" +
               "  \"sku\": \"FCC-S501-01-1\",\n" +
               "  \"attributedConversions7dSameSKU\": 0,\n" +
               "  \"attributedUnitsOrdered7dSameSKU\": 0,\n" +
               "  \"attributedConversions1dSameSKU\": 0,\n" +
               "  \"cost\": 0,\n" +
               "  \"adGroupName\": \"S501 白色\",\n" +
               "  \"attributedUnitsOrdered7d\": 0,\n" +
               "  \"attributedSales7dSameSKU\": 0,\n" +
               "  \"campaignId\": 229597135088044,\n" +
               "  \"attributedSales14dSameSKU\": 0,\n" +
               "  \"attributedSales30dSameSKU\": 0,\n" +
               "  \"impressions\": 0,\n" +
               "  \"attributedUnitsOrdered1d\": 0,\n" +
               "  \"attributedConversions30dSameSKU\": 0,\n" +
               "  \"adId\": 6717309237160,\n" +
               "  \"attributedUnitsOrdered14dSameSKU\": 0,\n" +
               "  \"attributedConversions14dSameSKU\": 0,\n" +
               "  \"clicks\": 0,\n" +
               "  \"asin\": \"B0792C67CK\",\n" +
               "  \"attributedSales14d\": 0,\n" +
               "  \"campaignName\": \"FCC-E251-auto-test1\",\n" +
               "  \"attributedUnitsOrdered30dSameSKU\": 0,\n" +
               "  \"attributedUnitsOrdered14d\": 0\n" +
               "}, {\n" +
               "  \"attributedUnitsOrdered1dSameSKU\": 0,\n" +
               "  \"attributedSales7d\": 0,\n" +
               "  \"attributedSales30d\": 0,\n" +
               "  \"attributedUnitsOrdered30d\": 0,\n" +
               "  \"attributedSales1d\": 0,\n" +
               "  \"attributedConversions1d\": 0,\n" +
               "  \"attributedSales1dSameSKU\": 0,\n" +
               "  \"attributedConversions30d\": 0,\n" +
               "  \"adGroupId\": 224699554566642,\n" +
               "  \"attributedConversions7d\": 0,\n" +
               "  \"attributedConversions14d\": 0,\n" +
               "  \"currency\": \"USD\",\n" +
               "  \"sku\": \"FCC-S501-01-b1\",\n" +
               "  \"attributedConversions7dSameSKU\": 0,\n" +
               "  \"attributedUnitsOrdered7dSameSKU\": 0,\n" +
               "  \"attributedConversions1dSameSKU\": 0,\n" +
               "  \"cost\": 0,\n" +
               "  \"adGroupName\": \"S501 白色\",\n" +
               "  \"attributedUnitsOrdered7d\": 0,\n" +
               "  \"attributedSales7dSameSKU\": 0,\n" +
               "  \"campaignId\": 229597135088044,\n" +
               "  \"attributedSales14dSameSKU\": 0,\n" +
               "  \"attributedSales30dSameSKU\": 0,\n" +
               "  \"impressions\": 0,\n" +
               "  \"attributedUnitsOrdered1d\": 0,\n" +
               "  \"attributedConversions30dSameSKU\": 0,\n" +
               "  \"adId\": 113159222474910,\n" +
               "  \"attributedUnitsOrdered14dSameSKU\": 0,\n" +
               "  \"attributedConversions14dSameSKU\": 0,\n" +
               "  \"clicks\": 0,\n" +
               "  \"asin\": \"B0792BWMV4\",\n" +
               "  \"attributedSales14d\": 0,\n" +
               "  \"campaignName\": \"FCC-E251-auto-test1\",\n" +
               "  \"attributedUnitsOrdered30dSameSKU\": 0,\n" +
               "  \"attributedUnitsOrdered14d\": 0\n" +
               "}, {\n" +
               "  \"attributedUnitsOrdered1dSameSKU\": 0,\n" +
               "  \"attributedSales7d\": 0,\n" +
               "  \"attributedSales30d\": 0,\n" +
               "  \"attributedUnitsOrdered30d\": 0,\n" +
               "  \"attributedSales1d\": 0,\n" +
               "  \"attributedConversions1d\": 0,\n" +
               "  \"attributedSales1dSameSKU\": 0,\n" +
               "  \"attributedConversions30d\": 0,\n" +
               "  \"adGroupId\": 224699554566642,\n" +
               "  \"attributedConversions7d\": 0,\n" +
               "  \"attributedConversions14d\": 0,\n" +
               "  \"currency\": \"USD\",\n" +
               "  \"sku\": \"FCC-S501-01-c1\",\n" +
               "  \"attributedConversions7dSameSKU\": 0,\n" +
               "  \"attributedUnitsOrdered7dSameSKU\": 0,\n" +
               "  \"attributedConversions1dSameSKU\": 0,\n" +
               "  \"cost\": 0,\n" +
               "  \"adGroupName\": \"S501 白色\",\n" +
               "  \"attributedUnitsOrdered7d\": 0,\n" +
               "  \"attributedSales7dSameSKU\": 0,\n" +
               "  \"campaignId\": 229597135088044,\n" +
               "  \"attributedSales14dSameSKU\": 0,\n" +
               "  \"attributedSales30dSameSKU\": 0,\n" +
               "  \"impressions\": 0,\n" +
               "  \"attributedUnitsOrdered1d\": 0,\n" +
               "  \"attributedConversions30dSameSKU\": 0,\n" +
               "  \"adId\": 96770845494950,\n" +
               "  \"attributedUnitsOrdered14dSameSKU\": 0,\n" +
               "  \"attributedConversions14dSameSKU\": 0,\n" +
               "  \"clicks\": 0,\n" +
               "  \"asin\": \"B0792BQJRD\",\n" +
               "  \"attributedSales14d\": 0,\n" +
               "  \"campaignName\": \"FCC-E251-auto-test1\",\n" +
               "  \"attributedUnitsOrdered30dSameSKU\": 0,\n" +
               "  \"attributedUnitsOrdered14d\": 0\n" +
               "}]";
        List list = JSON.parseArray(json, SpProductadsReport.class);
        System.out.println(list);
    }
}
