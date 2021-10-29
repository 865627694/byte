package com.waymap.o2o.cloud.provider.amazon.ad.service;

import com.waymap.o2o.cloud.common.base.utils.JsonResult;
import com.waymap.o2o.cloud.common.base.utils.NSParam;

import com.waymap.o2o.cloud.provider.amazon.ad.config.FeignConfig;
import com.waymap.o2o.cloud.provider.amazon.ad.service.impl.AccountsServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author blue
 * @description NS Account 服务
 * @email blue.liu@waymap.cn
 * @date 2019/8/2
 */
@FeignClient(value = "service-account", configuration = FeignConfig.class, fallback = AccountsServiceImpl.class)
public interface IAccountsService {
    /**
     * 请求NetSuite的RestLet脚本接口
     *
     * @param param 参数列表
     * @return
     */
    @RequestMapping(value = "ns/request")
    JsonResult<String> requestNetSuite(@RequestBody NSParam param);

    /**
     * 获取客户脚本线程数
     *
     * @param param 参数列表
     * @return
     */
    @RequestMapping(value = "ns/thread")
    JsonResult<Integer> getScriptThread(@RequestBody NSParam param);
}
