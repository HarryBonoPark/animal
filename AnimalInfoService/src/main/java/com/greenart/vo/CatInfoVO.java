package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CatInfoVO {
    private Integer seq;
    private String age;
    private String careAddr;
    private String careNm;
    private String careTel;
    private String chargeNm;
    private String colorCd;
    private String desertionNo;
    private String filename;
    private Date happenDt;
    private String happenPlace;
    private String kindCd;
    private String neuterYn;
    private Date noticeEdt;
    private String noticeNo;
    private Date noticeSdt;
    private String officetel;
    private String orgNm;
    private String popfile;
    private String processState;
    private String sexCd;
    private String specialMark;
    private String weight;

    private String sex;
    private String sexYn;
    private String region;

    private Integer c_cnt;
    private Integer c_noCnt;

    private String c_sex;
    private String c_region;
    private String c_careDogCnt;
    private String c_neuter;

    private String c_strCnt;
    private String c_strAllCnt;

    private String year;
    private String month;
    private String catCnt;

    private Integer catState;
    private String p_state;
    private String strCatState;
}
