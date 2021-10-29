package com.waymap.o2o.cloud.provider.amazon.ad.utils.convert;

import com.waymap.o2o.cloud.provider.amazon.ad.apiEntity.ApiSpKeywordsQueryReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpKeywordsQueryReport;
import com.waymap.o2o.cloud.provider.amazon.ad.nsEntity.NSSpKeywordsQueryReport;

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
public class SpKeywordsQueryReportConvert {
    public static List<SpKeywordsQueryReport> apiToDbEntity(List<ApiSpKeywordsQueryReport> list, AmazonAdReportSetting amazonAdReportSetting, LocalDateTime reportDate) {
        int reportSetId = amazonAdReportSetting.getId();
        List<SpKeywordsQueryReport> resultList = new ArrayList<>();
        list.forEach(apiEntity -> {
            SpKeywordsQueryReport dbEntity = new SpKeywordsQueryReport();
            dbEntity.setReportSetId(reportSetId);
            dbEntity.setReportDate(reportDate);
            dbEntity.setCreateDate(LocalDateTime.now());
            dbEntity.setUpdateDate(LocalDateTime.now());
            dbEntity.setCampaignName(apiEntity.getCampaignName());
            dbEntity.setCampaignId(apiEntity.getCampaignId());
            dbEntity.setAdGroupName(apiEntity.getAdGroupName());
            dbEntity.setAdGroupId(apiEntity.getAdGroupId());
            dbEntity.setKeywordId(apiEntity.getKeywordId());
            dbEntity.setKeywordText(apiEntity.getKeywordText());
            dbEntity.setMatchType(apiEntity.getMatchType());
            dbEntity.setImpressions(apiEntity.getImpressions());
            dbEntity.setClicks(apiEntity.getClicks());
            dbEntity.setCost(apiEntity.getCost());
            dbEntity.setAttributedConversions1d(apiEntity.getAttributedConversions1d());
            dbEntity.setAttributedConversions7d(apiEntity.getAttributedConversions7d());
            dbEntity.setAttributedConversions14d(apiEntity.getAttributedConversions14d());
            dbEntity.setAttributedConversions30d(apiEntity.getAttributedConversions30d());
            dbEntity.setAttributedConversions1dSameSku(apiEntity.getAttributedConversions1dSameSKU());
            dbEntity.setAttributedConversions7dSameSku(apiEntity.getAttributedConversions7dSameSKU());
            dbEntity.setAttributedConversions14dSameSku(apiEntity.getAttributedConversions14dSameSKU());
            dbEntity.setAttributedConversions30dSameSku(apiEntity.getAttributedConversions30dSameSKU());
            dbEntity.setAttributedUnitsOrdered1d(apiEntity.getAttributedUnitsOrdered1d());
            dbEntity.setAttributedUnitsOrdered7d(apiEntity.getAttributedUnitsOrdered7d());
            dbEntity.setAttributedUnitsOrdered14d(apiEntity.getAttributedUnitsOrdered14d());
            dbEntity.setAttributedUnitsOrdered30d(apiEntity.getAttributedUnitsOrdered30d());
            dbEntity.setAttributedSales1d(apiEntity.getAttributedSales1d());
            dbEntity.setAttributedSales7d(apiEntity.getAttributedSales7d());
            dbEntity.setAttributedSales14d(apiEntity.getAttributedSales14d());
            dbEntity.setAttributedSales30d(apiEntity.getAttributedSales30d());
            dbEntity.setAttributedSales1dSameSku(apiEntity.getAttributedSales1dSameSKU());
            dbEntity.setAttributedSales7dSameSku(apiEntity.getAttributedSales7dSameSKU());
            dbEntity.setAttributedSales14dSameSku(apiEntity.getAttributedSales14dSameSKU());
            dbEntity.setAttributedSales30dSameSku(apiEntity.getAttributedSales30dSameSKU());
            dbEntity.setAttributedUnitsOrdered1dSameSku(apiEntity.getAttributedUnitsOrdered1dSameSKU());
            dbEntity.setAttributedUnitsOrdered7dSameSku(apiEntity.getAttributedUnitsOrdered7dSameSKU());
            dbEntity.setAttributedUnitsOrdered14dSameSku(apiEntity.getAttributedUnitsOrdered14dSameSKU());
            dbEntity.setAttributedUnitsOrdered30dSameSku(apiEntity.getAttributedUnitsOrdered30dSameSKU());
            dbEntity.setQuery(apiEntity.getQuery());
            resultList.add(dbEntity);
        });
        return resultList;
    }

    public static List<NSSpKeywordsQueryReport> dbToNsEntity(List<SpKeywordsQueryReport> list) {
        List<NSSpKeywordsQueryReport> resultList = new ArrayList<>();
        list.forEach(dbEntity -> {
            NSSpKeywordsQueryReport nsEntity = new NSSpKeywordsQueryReport();
            nsEntity.setId(dbEntity.getId());
            nsEntity.setImpressions(dbEntity.getImpressions());
            nsEntity.setClicks(dbEntity.getClicks());
            nsEntity.setAttributedSales7d(dbEntity.getAttributedSales7d());
            nsEntity.setMatchType(dbEntity.getMatchType());
            nsEntity.setAttributedConversions7d(dbEntity.getAttributedConversions7d());
            nsEntity.setAttributedUnitsOrdered7dSameSKU(dbEntity.getAttributedUnitsOrdered7dSameSku());
            nsEntity.setCost(dbEntity.getCost());
            nsEntity.setAdGroupName(dbEntity.getAdGroupName());
            nsEntity.setAttributedUnitsOrdered7d(dbEntity.getAttributedUnitsOrdered7d());
            nsEntity.setAttributedSales7dSameSKU(dbEntity.getAttributedSales7dSameSku());
            nsEntity.setQuery(dbEntity.getQuery());
            nsEntity.setKeywordText(dbEntity.getKeywordText());
            nsEntity.setCampaignName(dbEntity.getCampaignName());
            LocalDateTime localDateTime=dbEntity.getReportDate();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            nsEntity.setDate(dateTimeFormatter.format(localDateTime));
            nsEntity.setYear(localDateTime.getYear()+"");
            nsEntity.setMonth(localDateTime.getMonthValue()+"");
            resultList.add(nsEntity);
        });
        return resultList;
    }
}
