package com.waymap.o2o.cloud.provider.amazon.ad.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author blue
 * @description Feign重试配置
 * @email blue.liu@waymap.cn
 * @date 2019/7/31
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, 3000, 5);
    }

}
