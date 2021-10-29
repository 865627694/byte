package com.waymap.o2o.cloud.provider.amazon.ad.utils.convert;

import com.waymap.o2o.cloud.provider.amazon.ad.apiEntity.ApiHsaKeywordsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.HsaKeywordsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.nsEntity.NSHsaKeywordsReport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blue
 * @description TODO
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
public class HsaKeywordsReportConvert {
    public static List<HsaKeywordsReport> apiToDbEntity(List<ApiHsaKeywordsReport> list, AmazonAdReportSetting amazonAdReportSetting, LocalDateTime reportDate) {
        int reportSetId = amazonAdReportSetting.getId();
        List<HsaKeywordsReport> resultList = new ArrayList<>();
        list.forEach(apiEntity -> {
            HsaKeywordsReport dbEntity = new HsaKeywordsReport();
            dbEntity.setReportSetId(reportSetId);
            dbEntity.setReportDate(reportDate);
            dbEntity.setCreateDate(LocalDateTime.now());
            dbEntity.setUpdateDate(LocalDateTime.now());
            dbEntity.setCampaignName(apiEntity.getCampaignName());
            dbEntity.setCampaignId(apiEntity.getCampaignId());
            dbEntity.setCampaignStatus(apiEntity.getCampaignStatus());
            dbEntity.setCampaignBudget(apiEntity.getCampaignBudget());
            dbEntity.setCampaignBudgetType(apiEntity.getCampaignBudgetType());
            dbEntity.setAdGroupName(apiEntity.getAdGroupName());
            dbEntity.setAdGroupId(apiEntity.getAdGroupId());
            dbEntity.setKeywordText(apiEntity.getKeywordText());
            dbEntity.setKeywordBid(apiEntity.getKeywordBid());
            dbEntity.setKeywordStatus(apiEntity.getKeywordStatus());
            dbEntity.setTargetId(apiEntity.getTargetId());
            dbEntity.setTargetingExpression(apiEntity.getTargetingExpression());
            dbEntity.setTargetingText(apiEntity.getTargetingText());
            dbEntity.setTargetingType(apiEntity.getTargetingType());
            dbEntity.setMatchType(apiEntity.getMatchType());
            dbEntity.setImpressions(apiEntity.getImpressions());
            dbEntity.setClicks(apiEntity.getClicks());
            dbEntity.setCost(apiEntity.getCost());
            dbEntity.setAttributedDetailPageViewsClicks14d(apiEntity.getAttributedDetailPageViewsClicks14d());
//            dbEntity.setAttributedSales14d(apiEntity.getAttributedSales14d());
//            dbEntity.setAttributedSales14dSameSku(apiEntity.getAttributedSales14dSameSKU());
//            dbEntity.setAttributedConversions14d(apiEntity.getAttributedConversions14d());
//            dbEntity.setAttributedConversions14dSameSku(apiEntity.getAttributedConversions14dSameSKU());
//            dbEntity.setAttributedOrdersNewToBrand14d(apiEntity.getAttributedOrdersNewToBrand14d());
//            dbEntity.setAttributedOrdersNewToBrandPercentage14d(apiEntity.getAttributedOrdersNewToBrandPercentage14d());
//            dbEntity.setAttributedOrdersNewToBrand14d(apiEntity.getAttributedOrdersNewToBrand14d());
//            dbEntity.setAttributedSalesNewToBrand14d(apiEntity.getAttributedSalesNewToBrand14d());
//            dbEntity.setAttributedSalesNewToBrandPercentage14d(apiEntity.getAttributedSalesNewToBrandPercentage14d());
//            dbEntity.setAttributedUnitsOrderedNewToBrand14d(apiEntity.getAttributedUnitsOrderedNewToBrand14d());
//            dbEntity.setAttributedUnitsOrderedNewToBrandPercentage14d(apiEntity.getAttributedUnitsOrderedNewToBrandPercentage14d());
//            dbEntity.setUnitsSold14d(apiEntity.getUnitsSold14d());
//            dbEntity.setDpv14d(apiEntity.getDpv14d());
            resultList.add(dbEntity);
        });
        return resultList;
    }

    public static List<NSHsaKeywordsReport> dbToNsEntity(List<HsaKeywordsReport> list) {
        List<NSHsaKeywordsReport> resultList = new ArrayList<>();
        list.forEach(dbEntity -> {
            NSHsaKeywordsReport nsEntity = new NSHsaKeywordsReport();
            nsEntity.setId(dbEntity.getId());
            nsEntity.setImpressions(dbEntity.getImpressions());
            nsEntity.setClicks(dbEntity.getClicks());
            nsEntity.setKeywordId(dbEntity.getKeywordBid());
            nsEntity.setMatchType(dbEntity.getMatchType());
            nsEntity.setAttributedOrdersNewToBrandPercentage14d(dbEntity.getAttributedOrdersNewToBrandPercentage14d());
            nsEntity.setAdGroupId(dbEntity.getAdGroupId());
            nsEntity.setKeywordBid(dbEntity.getKeywordBid());
            nsEntity.setKeywordStatus(dbEntity.getKeywordStatus());
            nsEntity.setAttributedOrdersNewToBrand14d(dbEntity.getAttributedOrdersNewToBrand14d());
            nsEntity.setAttributedConversions14d(dbEntity.getAttributedConversions14d());
            nsEntity.setCampaignStatus(dbEntity.getCampaignStatus());
            nsEntity.setAttributedSalesNewToBrandPercentage14d(dbEntity.getAttributedSalesNewToBrandPercentage14d());
            nsEntity.setAttributedUnitsOrderedNewToBrandPercentage14d(dbEntity.getAttributedUnitsOrderedNewToBrandPercentage14d());
            nsEntity.setAttributedSalesNewToBrand14d(dbEntity.getAttributedSalesNewToBrand14d());
            nsEntity.setCost(dbEntity.getCost());
            nsEntity.setKeywordText(dbEntity.getKeywordText());
            nsEntity.setCampaignBudget(dbEntity.getCampaignBudget());
            nsEntity.setUnitsSold14d(dbEntity.getUnitsSold14d());
            nsEntity.setAttributedOrdersNewToBrand14d(dbEntity.getAttributedOrdersNewToBrand14d());
            nsEntity.setAttributedUnitsOrderedNewToBrand14d(dbEntity.getAttributedUnitsOrderedNewToBrand14d());
            nsEntity.setAttributedSales14d(dbEntity.getAttributedSales14d());
            nsEntity.setCampaignName(dbEntity.getCampaignName());
            LocalDateTime localDateTime=dbEntity.getReportDate();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            nsEntity.setDate(dateTimeFormatter.format(localDateTime));
            resultList.add(nsEntity);
        });
        return resultList;
    }
}
