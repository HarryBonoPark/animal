package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.AnimalInfoVO;
import com.greenart.vo.CatInfoVO;
import com.greenart.vo.OtherInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimalInfoMapper {
    // DOG
    public void insertAnimalInfo(AnimalInfoVO vo);
    // public AnimalInfoVO selectAnimalInfoByDate(String date); // Today
    // public AnimalInfoVO selectAccAnimalCnt(String date); // 누적
    // public List<AnimalInfoVO> selectAnimalStatusByDate(String date);
    // public AnimalInfoVO selectAnimalStatusByDate();
    public AnimalInfoVO selectCntStatusByDate(String date);
    public AnimalInfoVO selectAllCntByDate();
    // public List<AnimalInfoVO> selectRegionInfoByDate(String date);
    // public List<AnimalInfoVO> selectanimalSex(String date);
    public List<AnimalInfoVO> selectSexAnimalCnt(String date);
    public List<AnimalInfoVO> selectCntRegion(String date);
    public List<AnimalInfoVO> selectNeuterCnt(String date);
    public List<AnimalInfoVO> selectMonthDogCnt(String date);
    public List<AnimalInfoVO> selectDogProcessState(String date);


    // CAT
    // public void insertCatInfo(CatInfoVO vo);
    public CatInfoVO selectCatCntStatusByDate(String date);
    public CatInfoVO selectAllCatCntByDate(String date);
    public List<CatInfoVO> selectCatSexAnimalCnt(String date);
    public List<CatInfoVO> selectCatCntRegion(String date);
    public List<CatInfoVO> selectCatNeuterCnt(String date);
    public List<CatInfoVO> selectMonthCatCnt(String date);
    public List<CatInfoVO> selectCatProcessState(String date);


    // Other
    public OtherInfoVO selectOtherCntStatusByDate(String date);
    public OtherInfoVO selectAllOtherCntByDate(String date);
    public List<OtherInfoVO> selectOtherSexAnimalCnt(String date);
    public List<OtherInfoVO> selectOtherCntRegion(String date);
    public List<OtherInfoVO> selectOtherNeuterCnt(String date);
    public List<OtherInfoVO> selectMonthOtherCnt(String date);
}
