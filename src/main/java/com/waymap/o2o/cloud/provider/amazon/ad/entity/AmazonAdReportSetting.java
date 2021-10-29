package com.waymap.o2o.cloud.provider.amazon.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author blue
 * @description 亚马逊广告报表抓取配置
 * @email blue.liu@waymap.cn
 * @date 2019/10/28
 */
@Data
@TableName("o2o_amazon_ad_report_setting")
public class AmazonAdReportSetting implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * o2o_amazon_ad_information id
     */
    private Integer informationId;
    /**
     * 亚马逊广告 profile，header中的Amazon-Advertising-API-Scope值
     */
    private String profile;
    /**
     * 亚马逊广告 internal_id,对应ns里面店铺的名字
     */
    private String internalId;
    /**
     * 报表大类
     */
    private String recordType;
    /**
     * 亚马逊广告 报表类型
     */
    private String reportType;
}
