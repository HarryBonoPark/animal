package com.greenart.vo;

import lombok.Data;

@Data
public class SupportVO {
    private Integer seq;
    private String name; 
    private String phone;
    private String password;
    private String email;
    private String title;
    private String content; 
    
    private String kind; 
    private String region; 
    //지역별 center가져오기
    private String careNm;
}
