package com.greenart.vo;

import java.util.Date;

import lombok.Data;

// @Data
// public class CenterInfoVO {
//     private String orgNm; // 지역
//     private String careNm; // 보호소 이름
//     private String careAddr; // 보호소 주소
//     private String careTel; // 보호소 전화번호
//     private String processState; // 보호중

//     private String careDogCnt; // 보호중인 강아지 마리수
//     private String region; // 지역
//     private Integer centerCnt; // 보호소 갯수
// }

@Data
public class CenterInfoVO {
    private Integer seq;
    private String careNm;              // 동물보호센터 명
    private String orgNm;               // 관리기관 명
    private String divisionNm;          // 동물보호센터 유형
    private String saveTrgtAnimal;      // 구조대상 동물
    private String careAddr;            // 소재지 도로명 주소
    private String jibunAddr;           // 소재지 지번 주소
    private Double lat;                 // 위도
    private Double lng;                 // 경도
    private Date dsignationDate;        // 동물 보호센터 지정 일자
    private String weekOprStime;        // 평일 운영 시작 시간
    private String weekOprEtime;        // 평일 운영 종료 시간
    private String weekCellStime;       // 평일 분양 시작 시간
    private String weekCellEtime;       // 평일 분양 종료 시간
    private String weekendOprStime;     // 주말 운영 시작 시간
    private String weekendOprEtime;     // 주말 운영 종료 시간
    private String weekendCellStime;    // 주말 분양 시작 시간
    private String weekendCellEtime;    // 주말 분양 종료 시간
    private String closeDay;            // 휴무일
    private Integer vetPersonCnt;       // 수의사 인원수
    private Integer specsPersonCnt;     // 사양 관리사 인원수
    private Integer medicalCnt;         // 진료실 수
    private Integer breedCnt;           // 사육실 수
    private Integer quarabtineCnt;      // 격리실 수
    private Integer feedCnt;            // 사료 보관실 수
    private String transCarCnt;         // 구조 운반용 차량 보유대수
    private String careTel;             // 전화번호
    private Date dataStdDt;             // 데이터 기준 일자

    private Integer centerCnt; // 보호소 갯수
}

