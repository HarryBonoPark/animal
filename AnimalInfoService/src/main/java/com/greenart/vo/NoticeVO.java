package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
    private Integer seq;
    private String title;
    private String content;
    private Integer ni_cate_seq;
    private Date create_dt;

    private String cate_name;
}
