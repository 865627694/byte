package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.HsaKeywordsReportMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.SpProductadsReportMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.HsaKeywordsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.service.HsaKeywordsReportService;
import com.waymap.o2o.cloud.provider.amazon.ad.service.SpProductadsReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Brands （recordType=keywords） 报表 service impl
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
@Service(value = "hsaKeywordsReportService")
public class HsaKeywordsReportServiceImpl extends ServiceImpl<HsaKeywordsReportMapper, HsaKeywordsReport> implements HsaKeywordsReportService {
    @Resource
    HsaKeywordsReportMapper hsaKeywordsReportMapper;

    @Override
    public void insertOrUpdateBatch(List<HsaKeywordsReport> hsaKeywordsReportList) {
        hsaKeywordsReportMapper.insertOrUpdateBatch(hsaKeywordsReportList);
    }

    @Override
    public List<HsaKeywordsReport> getFailureOrdersByAccountId(Map<String, Object> map) {
        return hsaKeywordsReportMapper.getFailureOrdersByAccountId(map);
    }
}
