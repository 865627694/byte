package com.waymap.o2o.cloud.provider.amazon.ad.controller;

import com.waymap.o2o.cloud.provider.amazon.ad.bo.NsAmazonAdBO;
import com.waymap.o2o.cloud.provider.amazon.ad.vo.NsAmazonAdVO;
import com.waymap.o2o.cloud.provider.amazon.ad.service.AmazonAdNSService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author blue&byte
 * @description NetSuite对接接口
 * @email blue.liu@waymap.cn
 * @date 2019/11/1&2021/9/14
 */
@RestController
@RequestMapping("ns")
@ApiIgnore
@Slf4j
public class NSController {
    @Resource
    private AmazonAdNSService amazonAdNSService;
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * @MethodName: reportPush
     * @Description: 推送报表
     * @Param: []
     * @Return: void
     * @Author: blue
     * @Date: 2019/1/11
     **/
    @RequestMapping("report/push")
    public synchronized void reportPush() {
        amazonAdNSService.reportPush();
    }

    /**
     * NS主动拉取报表
     * @param nsAmazonAdBO
     * @return
     */
    @PostMapping("report/pull")
    public synchronized NsAmazonAdVO reportPull(@RequestBody NsAmazonAdBO nsAmazonAdBO){
        NsAmazonAdVO nsAmazonAdVO = amazonAdNSService.reportPull(nsAmazonAdBO);
        return nsAmazonAdVO;
    }
}
