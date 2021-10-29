package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.waymap.o2o.cloud.provider.amazon.ad.bo.NsAmazonAdBO;
import com.waymap.o2o.cloud.provider.amazon.ad.vo.NsAmazonAdVO;

/**
 * @author blue
 * @description NS service
 * @email blue.liu@waymap.cn
 * @date 2019/11/1
 */
public interface AmazonAdNSService {
    /**
     * 推送亚马逊广告报表
     */
    void reportPush();

    NsAmazonAdVO reportPull(NsAmazonAdBO nsAmazonAdBO);
}
