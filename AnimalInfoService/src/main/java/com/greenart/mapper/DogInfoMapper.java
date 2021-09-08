package com.greenart.mapper;

import java.util.List;
import com.greenart.vo.DogInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DogInfoMapper {
    public List<DogInfoVO> selectRegionDogInfo(String region); //지역별 강아지 가져오기
    public DogInfoVO selectDogInfoById(Integer seq); //상세정보 가져오기

}
