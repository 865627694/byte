package com.waymap.o2o.cloud.provider.amazon.ad.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdInformation;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.AmazonAdReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport;
import feign.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 SP Productads 报表DAO
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
public interface SpProductadsReportMapper extends BaseMapper<SpProductadsReport> {
    /**
     * @MethodName: insertOrUpdateBatch
     * @Description: 批量插入或更新
     * 如果插入的记录导致一个UNIQUE索引或主键出现重复，那么就会认为该条记录存在，则执行更新语句，反之执行insert语句
     * @Param: [spProductadsReportList]
     * @Return: void
     * @Author: blue
     * @Date: 2019/10/31
     **/
//    void insertOrUpdateBatch(@Param("report") AmazonAdReport amazonAdReport);

    /**
     * @MethodName: getFailureOrdersByAccountId
     * @Description: 根据accountId查询出推送失败的记录列表
     * @Param: [map]
     * @Return: java.utils.List<com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport>
     * @Author: blue
     * @Date: 2019/11/1
     **/
    List<SpProductadsReport> getFailureOrdersByAccountId(Map<String, Object> map);

    /**
     * @MethodName: updatePushResult
     * @Description: 更新推送结果 用不了，要改数据库连接&allowMultiQueries=true
     * @Param: [spProductadsReportList]
     * @Return: void
     * @Author: blue
     * @Date: 2019/11/1
     **/
    void updatePushResult(@Param("list") List<SpProductadsReport> spProductadsReportList);
}
