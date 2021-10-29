package com.waymap.o2o.cloud.provider.amazon.ad.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdInformation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author blue
 * @description 亚马逊广告账号信息DAO
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
public interface AmazonAdInformationMapper extends BaseMapper<AmazonAdInformation> {
    /**
     * 获取可用的亚马逊广告账号列表
     *
     * @return List<AmazonAdInformation>
     */
    @Select("select * from o2o_amazon_ad_information where available = true")
    List<AmazonAdInformation> getAvailableInformation();
}
