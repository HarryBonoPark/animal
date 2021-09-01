package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class LostImageVO {
    private Integer aimg_seq;
    private Integer aimg_lost_seq;
    private String aimg_file_name;
    private String aimg_uri;
    private Date aimg_reg_dt;
    private Integer aimg_size;
}
