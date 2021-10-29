package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.AmazonAdInformationMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdInformation;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author blue
 * @description 亚马逊广告账号信息service impl
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
@Service(value = "amazonAdInformationService")
public class AmazonAdInformationServiceImpl extends ServiceImpl<AmazonAdInformationMapper, AmazonAdInformation> implements AmazonAdInformationService {
    @Resource
    AmazonAdInformationMapper amazonAdInformationMapper;

    @Override
    public List<AmazonAdInformation> availableInformationList() {
        return amazonAdInformationMapper.getAvailableInformation();
    }
}
