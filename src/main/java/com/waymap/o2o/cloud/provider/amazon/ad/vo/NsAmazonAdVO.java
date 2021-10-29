package com.waymap.o2o.cloud.provider.amazon.ad.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 从数据库查出报告返回NS
 * @author byte on 2021/9/14
 */
@Data
@TableName("o2o_amazon_ad_report")
public class NsAmazonAdVO {
    private Integer informationId;
    private Integer internalId;
    private String profile;
    private String recordType;
    private String reportType;
    private String content;
    private LocalDateTime reportDate;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String nsInternalId;
    private Integer success;
    private String message;
}