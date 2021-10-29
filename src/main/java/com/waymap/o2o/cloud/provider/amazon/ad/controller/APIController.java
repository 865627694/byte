package com.waymap.o2o.cloud.provider.amazon.ad.controller;

import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdAPIService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author blue&byte
 * @description 亚马逊广告对接接口
 * @email blue.liu@waymap.cn
 * @date 2019/10/31&2021/9/22
 */
@RestController
@RequestMapping("api")
@ApiIgnore
@Slf4j
public class APIController {
    @Resource
    private AmazonAdAPIService amazonAdAPIService;
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * @MethodName: reportGet
     * @Description: 获取亚马逊广告报表Id
     **/
    @RequestMapping("/report/get")
    public synchronized void reportGet() {
        amazonAdAPIService.reportGet();
    }

    /**
     * @MethodName: reportDownload
     * @Description: 下载亚马逊广告报告
     **/
    @RequestMapping("/report/download")
    public synchronized void reportDownload() {
        amazonAdAPIService.reportDownload();
    }
}
