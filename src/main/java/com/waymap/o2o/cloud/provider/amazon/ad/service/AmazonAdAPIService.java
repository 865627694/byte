package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.waymap.o2o.cloud.provider.amazon.ad.bo.NsAmazonAdBO;
import com.waymap.o2o.cloud.provider.amazon.ad.vo.NsAmazonAdVO;

/**
 * @author blue&byte
 * @description 亚马逊广告API服务
 * @email blue.liu@waymap.cn
 * @date 2019/10/28/2021/9/14
 */
public interface AmazonAdAPIService {

    /**
     * 批量获取亚马逊广告报表（向亚马逊请求reportId）,并存入数据库
     */
    void reportGet();
    /**
     * 批量下载亚马逊广告报表
     */
    void reportDownload();
    /**
     * 查询亚马逊广告报表
     */
    NsAmazonAdVO searchReport(NsAmazonAdBO nsAmazonAdBO);
}
