package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class LostInfoVO {
    private Integer seq;
    private String region;
    private Date lostDate;
    private String writerName;
    private String writerEmail;
    private String writerPhone;
    private String animalName;
    private String animalKind;
    private String animalKindMore;
    private String animalColor;
    private String animalSex;
    private String animalAge;
    private String lostPlace;
    private String specialMark;
    private String registNumber;
    private String image_uri;
}
