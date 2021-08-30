package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OtherInfoVO {
    private Integer seq;
    private String age;
    private String careAddr;
    private String careNm;
    private String careTel;
    private String colorCd;
    private String desertionNo;
    private String filename;
    private Date happenDt;
    private String happenPlace;
    private String kindCd;
    private String neuterYn;
    private Date noticeSdt;
    private Date noticeEdt;
    private String noticeNo;
    private String officetel;
    private String orgNm;
    private String popfile;
    private String processState;
    private String sexCd;
    private String specialMark;
    private String weight;

    private Integer o_cnt;
    private Integer o_noCnt;

    private String o_sex;
    private String o_region;
    private String careOtherCnt;
    private String o_neuter;

    private String o_strCnt;
    private String o_strAllCnt;

    private String year;
    private String month;
    private String otherCnt;

    private String kind;
    private String sex;
    private String sexYn;
}
