package com.waymap.o2o.cloud.provider.amazon.ad.utils;

/**
 * @author blue&byte
 * @description 亚马逊广告Util
 * @email blue.liu@waymap.cn
 * @date 2019/10/28&2021/9/13
 */
public class AmazonAdUtil {
    /**
     * 亚马逊广告报表的类型（感觉用起来好麻烦，还不如常量方便）
     */
    public enum AmazonAdReportType {
        /**
         * 亚马逊广告 For Sponsored Brands （recordType=campaigns） 报表
         */
        SB_CAMPAIGNS_REPORT("1"),
        /**
         * 亚马逊广告 For Sponsored Brands （recordType=campaigns） 报表
         */
        SB_CAMPAIGNS_VIDEO_REPORT("13"),
        /**
         * 亚马逊广告 For Sponsored Brands （recordType=adGroups） 报表
         */
        SB_ADGROUPS_REPORT("2"),
        /**
         * 亚马逊广告 For Sponsored Brands （recordType=keywords） 报表
         */
        SB_KEYWORDS_REPORT("3"),
        /**
         * 亚马逊广告 For Sponsored Display （recordType=campaigns） 报表
         */
        SD_CAMPAIGNS_REPORT("4"),
        /**
         * 亚马逊广告 For Sponsored Display （recordType=adGroups） 报表
         */
        SD_ADGROUPS_REPORT("5"),
        /**
         * 亚马逊广告 For Sponsored Display （recordType=productads） 报表
         */
        SD_PRODUCTADS_REPORT("6"),
        /**
         * 亚马逊广告 For Sponsored Display （recordType=targets） 报表
         */
        SD_TARGETS_REPORT("7"),
        /**
         * 亚马逊广告 For Sponsored Display （recordType=asins） 报表
         */
        SD_ASINS_REPORT("8"),
        /**
         * 亚马逊广告 For Sponsored Products （recordType=campaigns） 报表
         */
        SP_CAMPAIGNS_REPORT("9"),
        /**
         * 亚马逊广告 For Sponsored Products （recordType=adGroups） 报表
         */
        SP_ADGROUPS_REPORT("10"),
        /**
         * 亚马逊广告 For Sponsored Products （recordType=keywords） 报表
         */
        SP_KEYWORDS_REPORT("11"),
        /**
         * 亚马逊广告 For Sponsored Products （recordType=productads） 报表
         */
        SP_PRODUCTADS_REPORT("12"),
//        /**
//         * 亚马逊广告 For Sponsored Display （recordType=asins） 报表
//         */
//        SP_ASINS_REPORT("13"),
        /**
         * 亚马逊广告 For Sponsored Display （recordType=targets） 报表
         */
        SP_TARGETS_REPORT("14"),
        /**
         * 没找到
         */
        NOT_FOUND("not found");


        private String type;

        AmazonAdReportType(String type) {
            this.type = type;
        }

        public String getValue() {
            return type;
        }

        public static AmazonAdReportType getName(String value) {
            for (AmazonAdReportType amazonAdReportType : AmazonAdReportType.values()) {
                if (value.equals(amazonAdReportType.getValue())) {
                    return amazonAdReportType;
                }
            }
            return NOT_FOUND;
        }

        @Override
        public String toString() {
            return this.name() + "(" + this.type + ")";
        }
    }

    public static class ScriptName {
        /**
         * 保存 亚马逊广告报表 接口
         */
        public static final String SAVE_AMAZON_AD_REPORT_REST = "save_amazon_ad_report_rest";
    }

    /**
     * 一次推送最大数据量
     */
    public static final int PUSH_LIMIT = 800;

    public static void main(String[] args) {
        AmazonAdReportType.getName("1");
    }
}
