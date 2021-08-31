package com.greenart.vo;

import lombok.Data;

@Data
public class MemberInfoVO {
    private Integer seq;
    private String name;
    private String password;
    private String id;
    private String email;
    private String birth;
    private String gen;
    private String address;
    private String phone;
    private Integer status;
}
