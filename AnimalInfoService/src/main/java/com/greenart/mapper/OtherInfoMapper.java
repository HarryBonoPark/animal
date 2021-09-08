package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.OtherInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OtherInfoMapper {
    public void insertOtherInfo(OtherInfoVO vo); //기타동물 넣어주기
    public List<OtherInfoVO> selectRegionOtherInfo(String region); //지역별 기타동물
    public OtherInfoVO selectOtherById(Integer seq); //상세보기
}
