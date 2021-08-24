package com.greenart.vo;

import lombok.Data;

@Data
public class CenterInfoVO {
    private String orgNm; // 지역
    private String careNm; // 보호소 이름
    private String careAddr; // 보호소 주소
    private String careTel; // 보호소 전화번호
    private String processState; // 보호중

    private String careDogCnt; // 보호중인 강아지 마리수
    private String region; // 지역
    private Integer centerCnt; // 보호소 갯수
}
