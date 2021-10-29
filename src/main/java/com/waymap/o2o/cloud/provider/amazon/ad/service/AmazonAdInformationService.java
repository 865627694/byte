package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdInformation;

import java.util.List;

/**
 * @author blue
 * @description 亚马逊广告账号信息service
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
public interface AmazonAdInformationService extends IService<AmazonAdInformation> {
    /**
     * 获取可用的管易云账号列表
     *
     * @return
     */
    List<AmazonAdInformation> availableInformationList();
}
