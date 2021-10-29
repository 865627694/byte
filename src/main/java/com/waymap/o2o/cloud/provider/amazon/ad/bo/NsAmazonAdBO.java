package com.waymap.o2o.cloud.provider.amazon.ad.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 保存来自NS请求的参数
 *
 * @author byte on 2021/9/14
 */
@Data
public class NsAmazonAdBO {
    /**
     * o2o_amazon_ad_information id
     */
    private Integer informationId;
    /**
     * 亚马逊广告 profile，header中的Amazon-Advertising-API-Scope值
     */
    private String profile;
    /**
     * 报表大类
     */
    private String recordType;
    /**
     * 亚马逊广告 报表类型
     */
    private String reportType;
}