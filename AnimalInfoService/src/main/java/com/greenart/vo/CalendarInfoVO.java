package com.greenart.vo;



import lombok.Data;

@Data
public class CalendarInfoVO {
    private Integer seq;
    private Integer mi_seq;
    private String name;
    private String kind;
    private String title;
    private String detail;
    private String date;
    private String time_h;
    private String time_m;
    //지역 추가
    private String region;
    private String careNm;
    private String center_seq;



}
