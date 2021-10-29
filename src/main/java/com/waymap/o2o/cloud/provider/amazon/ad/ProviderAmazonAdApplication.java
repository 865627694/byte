package com.waymap.o2o.cloud.provider.amazon.ad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.waymap.o2o.cloud.provider.amazon.ad.dao")
@EnableFeignClients
public class ProviderAmazonAdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAmazonAdApplication.class, args);
    }

}
