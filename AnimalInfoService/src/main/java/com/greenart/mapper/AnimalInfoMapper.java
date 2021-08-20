package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.AnimalInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimalInfoMapper {
    public void insertAnimalInfo(AnimalInfoVO vo);
    public AnimalInfoVO selectAnimalInfoByDate(String date); // Today
    public AnimalInfoVO selectAccAnimalCnt(String date); // 누적

    public List<AnimalInfoVO> selectAnimalStatusByDate(String date);
}
