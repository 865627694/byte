package com.waymap.o2o.cloud.provider.amazon.ad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.SpKeywordsQueryReportMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.dao.SpProductadsReportMapper;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpKeywordsQueryReport;
import com.waymap.o2o.cloud.provider.amazon.ad.entity.SpProductadsReport;
import com.waymap.o2o.cloud.provider.amazon.ad.service.SpKeywordsQueryReportService;
import com.waymap.o2o.cloud.provider.amazon.ad.service.SpProductadsReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author blue
 * @description 亚马逊广告 For Sponsored Products（recordType=keywords;segment=query[search term]） 报表 service impl
 * @email blue.liu@waymap.cn
 * @date 2019/10/31
 */
@Service(value = "spKeywordsQueryReportServiceImpl")
public class SpKeywordsQueryReportServiceImpl extends ServiceImpl<SpKeywordsQueryReportMapper, SpKeywordsQueryReport> implements SpKeywordsQueryReportService {
    @Resource
    SpKeywordsQueryReportMapper spKeywordsQueryReportMapper;

    @Override
    public void insertOrUpdateBatch(List<SpKeywordsQueryReport> spKeywordsQueryReportList) {
        spKeywordsQueryReportMapper.insertOrUpdateBatch(spKeywordsQueryReportList);
    }

    @Override
    public List<SpKeywordsQueryReport> getFailureOrdersByAccountId(Map<String, Object> map) {
        return spKeywordsQueryReportMapper.getFailureOrdersByAccountId(map);
    }
}
