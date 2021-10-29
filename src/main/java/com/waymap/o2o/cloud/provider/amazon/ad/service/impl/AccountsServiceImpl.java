package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.waymap.o2o.cloud.common.base.utils.JsonResult;
import com.waymap.o2o.cloud.common.base.utils.NSParam;

import com.waymap.o2o.cloud.provider.amazon.ad.exception.BusinessException;
import com.waymap.o2o.cloud.provider.amazon.ad.service.IAccountsService;
import org.springframework.stereotype.Component;

/**
 * @author blue
 * @description NS Account 服务
 * @email blue.liu@waymap.cn
 * @date 2019/8/2
 */
@Component
public class AccountsServiceImpl implements IAccountsService {
    @Override
    public JsonResult<String> requestNetSuite(NSParam param) {
        throw new BusinessException("method requestNetSuite is hystrix, service-account service error");
    }

    @Override
    public JsonResult<Integer> getScriptThread(NSParam param) {
        throw new BusinessException("method getScriptThread is hystrix, service-account service error");
    }
}
