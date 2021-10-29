package com.waymap.o2o.cloud.provider.amazon.ad.exception;

import java.util.function.Supplier;

/**
 * @author blue
 * @description 业务异常
 * @email blue.liu@waymap.cn
 * @date 2019/7/31
 */
public class BusinessException extends RuntimeException implements Supplier<BusinessException> {
    public BusinessException(String message) {
        super(message);
    }

    @Override
    public BusinessException get() {
        return this;
    }
}
