package com.waymap.o2o.cloud.provider.amazon.ad.scheduled;

import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdAPIService;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdNSService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author blue@byte
 * @description 亚马逊广告报表定时器
        * @email blue.liu@waymap.cn
 * @date 2019/11/7&2021/9/22
        */
@Component
public class AmazonAdTask {
    @Resource
    private AmazonAdAPIService amazonAdAPIService;
    @Resource
    private AmazonAdNSService amazonAdNSService;

    /**
     * 每天1点从亚马逊请求报表id
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void reportGet() {
        amazonAdAPIService.reportGet();
    }

    /**
     * 每天2点从亚马逊下载报告
     */
    //测试每分钟执行一次
    //@Scheduled(cron = "0 0/1 * * * ?")
    @Scheduled(cron = "0 0 2 * * ?")
    public void reportDownload() {
        amazonAdAPIService.reportDownload();
    }
}
