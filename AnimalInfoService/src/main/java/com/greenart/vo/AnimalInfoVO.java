package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AnimalInfoVO {
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

    private Integer cnt;
    private Integer noCnt;

    private String sex;
    private String region;
    private String careDogCnt;
    private String neuter;

    private String strCnt;
    private String strAllCnt;
    // private String accAllCnt;
    
}
