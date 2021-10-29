package com.waymap.o2o.cloud.provider.amazon.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author blue
 * @description 亚马逊广告账号信息
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
@Data
@TableName("o2o_amazon_ad_information")
public class AmazonAdInformation implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 需要抓取广告的公司名
     */
    private String accountId;
    /**
     * 亚马逊广告 client_id
     */
    private String clientId;
    /**
     * 亚马逊广告 client_secret
     */
    private String clientSecret;
    /**
     * url前缀
     */
    private Integer urlPrefix;
    /**
     * 亚马逊广告 refresh_token
     */
    private String refreshToken;
    /**
     * 亚马逊广告 access_token
     */
    private String accessToken;
}
