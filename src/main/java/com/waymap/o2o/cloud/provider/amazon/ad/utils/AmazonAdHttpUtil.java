package com.waymap.o2o.cloud.provider.amazon.ad.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdInformation;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReportSetting;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StreamUtils;


import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author blue&byte
 * @description TODO
 * @email blue.liu@waymap.cn
 * @date 2019/10/28&2021/9/13
 */
public class AmazonAdHttpUtil {
    public static String SB_CAMPAIGNS_REPORT_URL = "https://advertising-api.amazon.com/v2/hsa/campaigns/report";//北美:1
    public static String SB_CAMPAIGNS_REPORT_URL_EU = "https://advertising-api-eu.amazon.com/v2/hsa/campaigns/report";//欧洲:2
    public static String SB_CAMPAIGNS_REPORT_URL_FE = "https://advertising-api-fe.amazon.com/v2/hsa/campaigns/report";//远东:3

    public static String SB_ADGROUPS_REPORT_URL = "https://advertising-api.amazon.com/v2/hsa/adGroups/report";
    public static String SB_KEYWORDS_REPORT_URL = "https://advertising-api.amazon.com/v2/hsa/keywords/report";

    public static String SD_CAMPAIGNS_REPORT_URL = "https://advertising-api.amazon.com/sd/campaigns/report";
    public static String SD_ADGROUPS_REPORT_URL = "https://advertising-api.amazon.com/sd/adGroups/report";

    public static String SD_PRODUCTADS_REPORT_URL = "https://advertising-api.amazon.com/sd/productAds/report";
    public static String SD_PRODUCTADS_REPORT_URL_EU = "https://advertising-api-eu.amazon.com/sd/productAds/report";
    public static String SD_PRODUCTADS_REPORT_URL_FE = "https://advertising-api-fe.amazon.com/sd/productAds/report";

    public static String SD_TARGETS_REPORT_URL = "https://advertising-api.amazon.com/sd/targets/report";
    public static String SD_ASINS_REPORT_URL = "https://advertising-api.amazon.com/sd/asins/report";


    public static String SP_CAMPAIGNS_REPORT_URL = "https://advertising-api.amazon.com/v2/sp/campaigns/report";
    public static String SP_ADGROUPS_REPORT_URL = "https://advertising-api.amazon.com/v2/sp/adGroups/report";
    public static String SP_KEYWORDS_REPORT_URL = "https://advertising-api.amazon.com/v2/sp/keywords/report";

    public static String SP_PRODUCTADS_REPORT_URL = "https://advertising-api.amazon.com/v2/sp/productAds/report";
    public static String SP_PRODUCTADS_REPORT_URL_EU = "https://advertising-api-eu.amazon.com/v2/sp/productAds/report";
    public static String SP_PRODUCTADS_REPORT_URL_FE = "https://advertising-api-fe.amazon.com/v2/sp/productAds/report";

    public static String SP_ASINS_REPORT_URL = "https://advertising-api.amazon.com/v2/sp/asins/report";
    public static String SP_TARGETS_REPORT_URL = "https://advertising-api.amazon.com/v2/sp/targets/report";


    public static String FRESH_TOKEN_URL = "https://api.amazon.com/auth/o2/token";
    public static String FRESH_TOKEN_URL_EU = "https://api.amazon.co.uk/auth/o2/token";
    public static String FRESH_TOKEN_URL_FE = "https://api.amazon.co.jp/auth/o2/token";

    public static String DOWNLOAD_REPORT_PREFIX = "https://advertising-api.amazon.com/v2/reports/";
    public static String DOWNLOAD_REPORT_PREFIX_EU = "https://advertising-api-eu.amazon.com/v2/reports/";
    public static String DOWNLOAD_REPORT_PREFIX_FE = "https://advertising-api-fe.amazon.com/v2/reports/";

    public static String DOWNLOAD_REPORT_SUFFIX = "/download";

    public static String getAmazonAdReportId(AmazonAdInformation amazonAdInformation, AmazonAdReportSetting amazonAdReportSetting, String reportDate) {
        String url;
        String requestJson;
        JSONObject jsonObject = new JSONObject();
        switch (AmazonAdUtil.AmazonAdReportType.getName(amazonAdReportSetting.getReportType())) {
            //SB
            case SB_CAMPAIGNS_REPORT:
                if (amazonAdInformation.getUrlPrefix() == 1) {
                    url = SB_CAMPAIGNS_REPORT_URL;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("metrics", "currency,campaignName,impressions,clicks,cost,attributedSales14d,unitsSold14d,attributedConversions14d,attributedOrdersNewToBrand14d,attributedOrdersNewToBrandPercentage14d,attributedSalesNewToBrand14d,attributedSalesNewToBrandPercentage14d,attributedUnitsOrderedNewToBrand14d,attributedUnitsOrderedNewToBrandPercentage14d,attributedOrderRateNewToBrand14d");
                    requestJson = jsonObject.toString();
                    break;
                } else if (amazonAdInformation.getUrlPrefix() == 2) {
                    url = SB_CAMPAIGNS_REPORT_URL_EU;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("metrics", "currency,campaignName,impressions,clicks,cost,attributedSales14d,unitsSold14d,attributedConversions14d,attributedOrdersNewToBrand14d,attributedOrdersNewToBrandPercentage14d,attributedSalesNewToBrand14d,attributedSalesNewToBrandPercentage14d,attributedUnitsOrderedNewToBrand14d,attributedUnitsOrderedNewToBrandPercentage14d,attributedOrderRateNewToBrand14d");
                    requestJson = jsonObject.toString();
                    break;
                } else {
                    url = SB_CAMPAIGNS_REPORT_URL_FE;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("metrics", "currency,campaignName,impressions,clicks,cost,attributedSales14d,unitsSold14d,attributedConversions14d,attributedOrdersNewToBrand14d,attributedOrdersNewToBrandPercentage14d,attributedSalesNewToBrand14d,attributedSalesNewToBrandPercentage14d,attributedUnitsOrderedNewToBrand14d,attributedUnitsOrderedNewToBrandPercentage14d,attributedOrderRateNewToBrand14d");
                    requestJson = jsonObject.toString();
                    break;
                }
            case SB_CAMPAIGNS_VIDEO_REPORT:
                if (amazonAdInformation.getUrlPrefix() == 1) {
                    url = SB_CAMPAIGNS_REPORT_URL;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("creativeType", "video");
                    jsonObject.put("metrics", "currency,attributedConversions14d,viewableImpressions,vtr,vctr,videoFirstQuartileViews,videoMidpointViews,videoThirdQuartileViews,videoCompleteViews,videoUnmutes,video5SecondViews,video5SecondViewRate,campaignName,impressions,clicks,cost,attributedSales14d");
                    requestJson = jsonObject.toString();
                    break;
                } else if (amazonAdInformation.getUrlPrefix() == 2) {
                    url = SB_CAMPAIGNS_REPORT_URL_EU;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("creativeType", "video");
                    jsonObject.put("metrics", "currency,attributedConversions14d,viewableImpressions,vtr,vctr,videoFirstQuartileViews,videoMidpointViews,videoThirdQuartileViews,videoCompleteViews,videoUnmutes,video5SecondViews,video5SecondViewRate,campaignName,impressions,clicks,cost,attributedSales14d");
                    requestJson = jsonObject.toString();
                    break;
                } else {
                    url = SB_CAMPAIGNS_REPORT_URL_FE;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("creativeType", "video");
                    jsonObject.put("metrics", "currency,attributedConversions14d,viewableImpressions,vtr,vctr,videoFirstQuartileViews,videoMidpointViews,videoThirdQuartileViews,videoCompleteViews,videoUnmutes,video5SecondViews,video5SecondViewRate,campaignName,impressions,clicks,cost,attributedSales14d");
                    requestJson = jsonObject.toString();
                    break;
                }
            case SB_ADGROUPS_REPORT:
                url = SB_ADGROUPS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("metrics", "campaignId,campaignName,campaignBudget,campaignBudgetType,campaignStatus,adGroupName,adGroupId");
                requestJson = jsonObject.toString();
                break;
            case SB_KEYWORDS_REPORT:
                url = SB_KEYWORDS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("metrics", "campaignId,campaignName,adGroupId,adGroupName,campaignBudgetType,campaignStatus,keywordId,keywordStatus,keywordBid,keywordText,matchType");
                requestJson = jsonObject.toString();
                break;

            //SD
            case SD_CAMPAIGNS_REPORT:
                url = SD_CAMPAIGNS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("tactic", "T00020");
                jsonObject.put("metrics", "campaignName,campaignId,impressions,clicks,cost,currency");
                requestJson = jsonObject.toString();
                break;
            case SD_ADGROUPS_REPORT:
                url = SD_ADGROUPS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("tactic", "T00020");
                jsonObject.put("metrics", "campaignName,campaignId,impressions,clicks,cost,currency");
                requestJson = jsonObject.toString();
                break;
            case SD_PRODUCTADS_REPORT:
                if (amazonAdInformation.getUrlPrefix() == 1) {
                    url = SD_PRODUCTADS_REPORT_URL;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("tactic", "T00020");
                    jsonObject.put("metrics", "attributedUnitsOrdered14d,attributedSales14d,attributedOrdersNewToBrand14d,attributedSalesNewToBrand14d,attributedUnitsOrderedNewToBrand14d,campaignName,adGroupName,sku,asin,impressions,clicks,cost,currency");
                    requestJson = jsonObject.toString();
                    break;
                } else if (amazonAdInformation.getUrlPrefix() == 2) {
                    url = SD_PRODUCTADS_REPORT_URL_EU;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("tactic", "T00020");
                    jsonObject.put("metrics", "attributedUnitsOrdered14d,attributedSales14d,attributedOrdersNewToBrand14d,attributedSalesNewToBrand14d,attributedUnitsOrderedNewToBrand14d,campaignName,adGroupName,sku,asin,impressions,clicks,cost,currency");
                    requestJson = jsonObject.toString();
                    break;
                } else {
                    url = SD_PRODUCTADS_REPORT_URL_FE;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("tactic", "T00020");
                    jsonObject.put("metrics", "attributedUnitsOrdered14d,attributedSales14d,attributedOrdersNewToBrand14d,attributedSalesNewToBrand14d,attributedUnitsOrderedNewToBrand14d,campaignName,adGroupName,sku,asin,impressions,clicks,cost,currency");
                    requestJson = jsonObject.toString();
                    break;
                }
            case SD_TARGETS_REPORT:
                url = SD_TARGETS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("tactic", "T00020");
                jsonObject.put("metrics", "campaignName,campaignId,impressions,clicks,cost");
                requestJson = jsonObject.toString();
                break;
            case SD_ASINS_REPORT:
                url = SD_ASINS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("tactic", "T00020");
                jsonObject.put("metrics", "campaignName,campaignId,adGroupName,adGroupId,asin");
                requestJson = jsonObject.toString();
                break;

            //SP
            case SP_CAMPAIGNS_REPORT:
                url = SP_CAMPAIGNS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("metrics", "bidPlus,campaignName,campaignId,campaignStatus,campaignBudget,campaignRuleBasedBudget");
                requestJson = jsonObject.toString();
                break;
            case SP_ADGROUPS_REPORT:
                url = SP_ADGROUPS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("metrics", "campaignName,campaignId,adGroupName,adGroupId,impressions,clicks,cost");
                requestJson = jsonObject.toString();
                break;
            case SP_KEYWORDS_REPORT:
                url = SP_KEYWORDS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("metrics", "campaignName,campaignId,adGroupName,adGroupId,impressions,clicks,cost");
                requestJson = jsonObject.toString();
                break;
            case SP_PRODUCTADS_REPORT:
                if (amazonAdInformation.getUrlPrefix() == 1) {
                    url = SP_PRODUCTADS_REPORT_URL;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("metrics", "currency,campaignName,adGroupName,sku,asin,impressions,clicks,cost,attributedSales7d,attributedUnitsOrdered7dSameSKU,attributedSales7dSameSKU");
                    requestJson = jsonObject.toString();
                    break;
                } else if (amazonAdInformation.getUrlPrefix() == 2) {
                    url = SP_PRODUCTADS_REPORT_URL_EU;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("metrics", "currency,campaignName,adGroupName,sku,asin,impressions,clicks,cost,attributedSales7d,attributedUnitsOrdered7dSameSKU,attributedSales7dSameSKU");
                    requestJson = jsonObject.toString();
                    break;
                } else {
                    url = SP_PRODUCTADS_REPORT_URL_FE;
                    jsonObject.put("reportDate", reportDate);
                    jsonObject.put("metrics", "currency,campaignName,adGroupName,sku,asin,impressions,clicks,cost,attributedSales7d,attributedUnitsOrdered7dSameSKU,attributedSales7dSameSKU");
                    requestJson = jsonObject.toString();
                    break;
                }
                //TODO 暂时不支持
//            case SP_ASINS_REPORT:
//                url = SP_ASINS_REPORT_URL;
//                jsonObject.put("reportDate", reportDate);
//                jsonObject.put("metrics", "campaignName,campaignId,adGroupName,adGroupId,keywordId,keywordText");
//                requestJson = jsonObject.toString();
//                break;
            case SP_TARGETS_REPORT:
                url = SP_TARGETS_REPORT_URL;
                jsonObject.put("reportDate", reportDate);
                jsonObject.put("metrics", "campaignName,campaignId,adGroupName,adGroupId,impressions,clicks,cost");
                requestJson = jsonObject.toString();
                break;
//            case SP_CAMPAIGNS_PLACEMENT_REPORT:
//                url = SP_CAMPAIGNS_REPORT_URL;
//                jsonObject.put("reportDate", reportDate);
//                jsonObject.put("metrics", "bidPlus,campaignName,campaignId,campaignStatus,campaignBudget,impressions,clicks,cost,attributedConversions1d,attributedConversions7d,attributedConversions14d,attributedConversions30d,attributedConversions1dSameSKU,attributedConversions7dSameSKU,attributedConversions14dSameSKU,attributedConversions30dSameSKU,attributedUnitsOrdered1d,attributedUnitsOrdered7d,attributedUnitsOrdered14d,attributedUnitsOrdered30d,attributedSales1d,attributedSales7d,attributedSales14d,attributedSales30d,attributedSales1dSameSKU,attributedSales7dSameSKU,attributedSales14dSameSKU,attributedSales30dSameSKU,attributedUnitsOrdered1dSameSKU,attributedUnitsOrdered7dSameSKU,attributedUnitsOrdered14dSameSKU,attributedUnitsOrdered30dSameSKU");
//                requestJson = jsonObject.toString();
//                break;
//            case SP_KEYWORDS_QUERY_REPORT:
//                url = SP_KEYWORDS_REPORT_URL;
//                jsonObject.put("reportDate", reportDate);
//                jsonObject.put("metrics", "campaignName,campaignId,adGroupName,adGroupId,keywordId,keywordText,matchType,impressions,clicks,cost,attributedConversions1d,attributedConversions7d,attributedConversions14d,attributedConversions30d,attributedConversions1dSameSKU,attributedConversions7dSameSKU,attributedConversions14dSameSKU,attributedConversions30dSameSKU,attributedUnitsOrdered1d,attributedUnitsOrdered7d,attributedUnitsOrdered14d,attributedUnitsOrdered30d,attributedSales1d,attributedSales7d,attributedSales14d,attributedSales30d,attributedSales1dSameSKU,attributedSales7dSameSKU,attributedSales14dSameSKU,attributedSales30dSameSKU,attributedUnitsOrdered1dSameSKU,attributedUnitsOrdered7dSameSKU,attributedUnitsOrdered14dSameSKU,attributedUnitsOrdered30dSameSKU");
//                requestJson = jsonObject.toString();
//                break;
            default:
                return null;
        }
        String accessToken = amazonAdInformation.getAccessToken();
        String clientId = amazonAdInformation.getClientId();
        String profile = amazonAdReportSetting.getProfile();
        String result = amazonAdPost(url, requestJson, accessToken, clientId, profile);
        //判断token是否失效
        JSONObject resultJson = JSON.parseObject(result);
        if (resultJson.containsKey("code") && "UNAUTHORIZED".equals(resultJson.getString("code"))) {
            //刷新token，并重新发送请求
            accessToken = refreshTokenPost(amazonAdInformation);
            amazonAdInformation.setAccessToken(accessToken);
            result = amazonAdPost(url, requestJson, accessToken, clientId, profile);
            resultJson = JSON.parseObject(result);
        }
        return resultJson.getString("reportId");
    }

    /**
     * @MethodName: amazonAdPost
     * @Description: 亚马逊广告post
     * @Param: [url, requestJson, accessToken, clientId, profile]
     * @Return: java.lang.String
     * @Author: blue
     * @Date: 2019/10/28
     **/
    public static String amazonAdPost(String url, String requestJson, String accessToken, String clientId, String profile) {
        String authorization = "Bearer " + accessToken;
        Map<String, String> header = new HashMap<>();
        header.put("Amazon-Advertising-API-ClientId", clientId);
        header.put("Amazon-Advertising-API-Scope", profile);
        return post(url, requestJson, authorization, header);
    }

    /**
     * @MethodName: refreshTokenPost
     * @Description: 刷新token，直接返回新的accesstoken
     * @Param: [amazonAdInformation]
     * @Return: java.lang.String
     * @Author: blue
     * @Date: 2019/10/28
     **/
    public static String refreshTokenPost(AmazonAdInformation amazonAdInformation) {
        String url;
        if (amazonAdInformation.getUrlPrefix() == 1) {
            url = FRESH_TOKEN_URL;

        } else if (amazonAdInformation.getUrlPrefix() == 2) {
            url = FRESH_TOKEN_URL_EU;

        } else {
            url = FRESH_TOKEN_URL_FE;

        }
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/x-www-form-urlencoded");
        StringBuffer requestBody = new StringBuffer();
        requestBody.append("grant_type=refresh_token");
        requestBody.append("&client_id=");
        requestBody.append(amazonAdInformation.getClientId());
        requestBody.append("&client_secret=");
        requestBody.append(amazonAdInformation.getClientSecret());
        requestBody.append("&refresh_token=");
        requestBody.append(amazonAdInformation.getRefreshToken());
        String result = post(url, requestBody.toString(), null, header);
        JSONObject resultJson = JSON.parseObject(result);
        String accessToken = resultJson.getString("access_token");
        System.out.println("新的access_token：" + accessToken);
        return accessToken;
    }

    /**
     * @MethodName: post
     * @Description: 通用post请求
     * @Param: [url, requestJson, authorization, header]
     * @Return: java.lang.String
     * @Author: blue
     * @Date: 2019/10/28
     **/
    public static String post(String url, String requestBody, String authorization, Map<String, String> header) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Post请求
        HttpPost httpPost = new HttpPost(url);

        StringEntity entity = new StringEntity(requestBody, "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);
        if (header != null) {
            if (!header.containsKey("Content-Type")) {
                header.put("Content-Type", "application/json;charset=utf8");
            }
            header.forEach(httpPost::setHeader);
        }
        if (authorization != null) {
            httpPost.setHeader("Authorization", authorization);
        }

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return EntityUtils.toString(responseEntity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String doAmazonAdDownloadFile(AmazonAdInformation amazonAdInformation, AmazonAdReportSetting amazonAdReportSetting, String reportId, String destPath) {
        String url;
        if (amazonAdInformation.getUrlPrefix() == 1) {
            url = DOWNLOAD_REPORT_PREFIX + reportId + DOWNLOAD_REPORT_SUFFIX;

        } else if (amazonAdInformation.getUrlPrefix() == 2) {
            url = DOWNLOAD_REPORT_PREFIX_EU + reportId + DOWNLOAD_REPORT_SUFFIX;

        } else {
            url = DOWNLOAD_REPORT_PREFIX_FE + reportId + DOWNLOAD_REPORT_SUFFIX;

        }

        String accessToken = amazonAdInformation.getAccessToken();
        String clientId = amazonAdInformation.getClientId();
        String profile = amazonAdReportSetting.getProfile();
        String result = amazonAdDownloadFile(url, destPath, accessToken, clientId, profile);
        //判断token是否失效
        JSONObject resultJson = JSON.parseObject(result);
        if (resultJson.containsKey("code") && "UNAUTHORIZED".equals(resultJson.getString("code"))) {
            //刷新token，并重新发送请求
            accessToken = refreshTokenPost(amazonAdInformation);
            amazonAdInformation.setAccessToken(accessToken);
            result = amazonAdDownloadFile(url, destPath, accessToken, clientId, profile);
        }
        return result;
    }

    /**
     * @MethodName: amazonAddownloadFile
     * @Description: 亚马逊广告下载文件
     * @Param: [url, destPath, accessToken, clientId, profile]
     * @Return: java.lang.String
     * @Author: blue
     * @Date: 2019/10/29
     **/
    public static String amazonAdDownloadFile(String url, String destPath, String accessToken, String clientId, String profile) {
        String fileName = "temp.json.zip";
        String authorization = "Bearer " + accessToken;
        Map<String, String> header = new HashMap<>();
        header.put("Amazon-Advertising-API-ClientId", clientId);
        header.put("Amazon-Advertising-API-Scope", profile);
        return downloadFile(url, destPath, fileName, authorization, header);
    }

    /**
     * @MethodName: downloadFile
     * @Description: 通用下载文件get请求
     * @Param: [url, destPath, fileName, authorization, header]
     * @Return: java.lang.String
     * @Author: blue
     * @Date: 2019/10/29
     **/
    public static String downloadFile(String url, String destPath, String fileName, String authorization, Map<String, String> header) {
        try {
            File desc = new File(destPath + File.separator + fileName);
            File folder = desc.getParentFile();
            folder.mkdirs();
            try (InputStream is = downloadFileGet(url, authorization, header);
                 OutputStream os = new FileOutputStream(desc)) {
                StreamUtils.copy(is, os);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return destPath + File.separator + fileName;
    }

    public static String doAmazonAdGetJsonInGz(AmazonAdInformation amazonAdInformation, String profile, String reportId) {
        String url;
        if (amazonAdInformation.getUrlPrefix() == 1) {
            url = DOWNLOAD_REPORT_PREFIX + reportId + DOWNLOAD_REPORT_SUFFIX;

        } else if (amazonAdInformation.getUrlPrefix() == 2) {
            url = DOWNLOAD_REPORT_PREFIX_EU + reportId + DOWNLOAD_REPORT_SUFFIX;

        } else {
            url = DOWNLOAD_REPORT_PREFIX_FE + reportId + DOWNLOAD_REPORT_SUFFIX;

        }

        String accessToken = amazonAdInformation.getAccessToken();
        String clientId = amazonAdInformation.getClientId();
//        String profile = amazonAdReportSetting.getProfile();
        String result = amazonAdGetJsonInGz(url, accessToken, clientId, profile);
        //判断token是否失效
        if (result == null) {
            //刷新token，并重新发送请求
            accessToken = refreshTokenPost(amazonAdInformation);
            amazonAdInformation.setAccessToken(accessToken);
            result = amazonAdGetJsonInGz(url, accessToken, clientId, profile);
        }
        return result;
    }

    /**
     * @MethodName: amazonAdGetJsonInGz
     * @Description: 亚马逊广告获取.gz文件里的json字符串
     * @Param: [url, destPath, accessToken, clientId, profile]
     * @Return: java.lang.String
     * @Author: blue
     * @Date: 2019/10/29
     **/
    public static String amazonAdGetJsonInGz(String url, String accessToken, String clientId, String profile) {
        String authorization = "Bearer " + accessToken;
        Map<String, String> header = new HashMap<>();
        header.put("Amazon-Advertising-API-ClientId", clientId);
        header.put("Amazon-Advertising-API-Scope", profile);
        return getJsonInGz(url, authorization, header);
    }

    /**
     * @MethodName: getJsonInGz
     * @Description: 获取.gz文件里的json字符串
     * @Param: [url, destPath, fileName, authorization, header]
     * @Return: java.lang.String
     * @Author: blue
     * @Date: 2019/10/29
     **/
    public static String getJsonInGz(String url, String authorization, Map<String, String> header) {
        String json = null;
        try {
            InputStream stream = downloadFileGet(url, authorization, header);
            if (stream != null) {
                json = GZipFileUtil.uncompressGetJson(stream);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * @MethodName: downloadFileGet
     * @Description: 通用下载文件get请求
     * @Param: [url, destPath, fileName, authorization, header]
     * @Return: java.lang.String
     * @Author: blue
     * @Date: 2019/10/29
     **/
    public static InputStream downloadFileGet(String url, String authorization, Map<String, String> header) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setRedirectStrategy(new DefaultRedirectStrategy() {
                        @Override
                        public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context) {
                            boolean isRedirect = false;
                            try {
                                isRedirect = super.isRedirected(request, response, context);
                            } catch (ProtocolException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            if (!isRedirect) {
                                int responseCode = response.getStatusLine().getStatusCode();
                                if (responseCode == 301 || responseCode == 302 || responseCode == 307) {
                                    request.removeHeaders("Authorization");
                                    return true;
                                }
                            } else {
                                //亚马逊会重定向到另一个地址，由于把之前请求的Authorization带过去会导致请求出错，所以要手动删除
                                request.removeHeaders("Authorization");
                            }
                            return isRedirect;
                        }
                    }).build();

            HttpGet httpGet = new HttpGet(url);
            if (header != null) {
                header.forEach(httpGet::setHeader);
            }
            if (authorization != null) {
                httpGet.setHeader("Authorization", authorization);
            }
//            TimeUnit.SECONDS.sleep(20);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
//                TimeUnit.SECONDS.sleep(30);
//                测试用，打印结果
//                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//                StringBuffer sb = new StringBuffer("");
//                String line = "";
//                String NL = System.getProperty("line.separator");
//                while ((line = in.readLine()) != null) {
//                    sb.append(line + NL);
//                }
//                in.close();
//                System.out.println(sb.toString());
                return copyInputStream(response.getEntity().getContent());
            } catch (Throwable e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream copyInputStream(InputStream inputStream) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(baos.toByteArray());
    }

    public static void main(String[] args) {
        String url = "https://advertising-api.amazon.com/v2/reports/amzn1.clicksAPI.v1.p1.5DB68A84.47756269-ca5b-43de-813c-dc7aaa610a20/download";
        String destPath = "E:\\";
        String fileName = "temp.json.zip";
        String accessToken = "Atza|IwEBIJ1wOvkkxZZi6ya_i8R6pJayvmlW0Xt2S_80UfB9CD2Z9woQDjpQ-ptcgGoPCvPnGNVPNlg3lFzgiXqc707GJy5EzeWhl1pDNjAPPflG6tevC1mYIqy5lECXCZ-BbPQPopdjrRlLrzdB03h_os6UaQvkQVbbTJxj9dnr9PL-GVAr2nLj1JQND8r6nhSYXjoJZdlY0ZOuosTKu51vfO_u_2bdjuUk0o7NxcWa1nlBB3me9FfbJz9q6J4AV6xAVAZKMFL3Ox17HU-6J5Hg5ZG4JXMgJa9kKZCR5stU_A8FuzZ9t2rdcPTbc_2Kje5OPL9yXtzlCTYMkdxJMip4agvnu9_Yt_7iVTwbezLBmKuUxTXlGFWzbHEbVOokk6ku10yLTGSFEV1l98lFt4wJLuvw6wk7YIeVu_bmHTm5rGinu28RWav1dUXtYBzWE5spMHODSR5RnBD2Oc3X5zwkf5L5exeYkwG7ayZuHI4M3vnaQ-yLILnslVgI4PRxp4_B5VXo9ZwfSdTdXnhLHkeR3e8XZupG2Qwq7oxjZQFtNq1_ekea_2dnyY3d68B3Ru2rzcLaIVdalgwk4tCy9W9jIkeUgLrKT_XUNVD9yqkuD5e4D3jYY4O4iJo6e5UQXFZhn5pAZ9r7gmzsBSReC8JOSYd9mBuzeITaVXEHXDjM5x81AP6N0w";
        String clientId = "amzn1.application-oa2-client.f13eda1bb1104e6f9f540237883cdde7";
        String profile = "584976763132478";
        try {
            amazonAdDownloadFile(url, destPath, accessToken, clientId, profile);
//            downLoadFromUrl(url,fileName,destPath);
//            downloadFile(url, destPath, fileName, null, null);
//            doGet(url);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
