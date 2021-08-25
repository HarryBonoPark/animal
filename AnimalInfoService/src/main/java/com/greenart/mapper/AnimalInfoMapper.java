package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.AnimalInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimalInfoMapper {
    public void insertAnimalInfo(AnimalInfoVO vo);
    public AnimalInfoVO selectAnimalInfoByDate(String date); // Today
    public AnimalInfoVO selectAccAnimalCnt(String date); // 누적

    // public List<AnimalInfoVO> selectAnimalStatusByDate(String date);
    // public AnimalInfoVO selectAnimalStatusByDate();
    public AnimalInfoVO selectCntStatusByDate(String date);
    // public AnimalInfoVO selectAllCntByDate(String date);
    public AnimalInfoVO selectAllCntByDate();

    public List<AnimalInfoVO> selectRegionInfoByDate(String date);

    public List<AnimalInfoVO> selectanimalSex(String date);

    public List<AnimalInfoVO> selectSexAnimalCnt(String date);
    public List<AnimalInfoVO> selectCntRegion(String date);
    public List<AnimalInfoVO> selectNeuterCnt(String date);
}
