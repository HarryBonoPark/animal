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
    public AnimalInfoVO selectCntStatusByDate(String date);
    public AnimalInfoVO selectAllCntByDate();
    public List<AnimalInfoVO> selectSexAnimalCnt(String date);
    public List<AnimalInfoVO> selectCntRegion(String date);
    public List<AnimalInfoVO> selectNeuterCnt(String date);
    public List<AnimalInfoVO> selectMonthDogCnt(String date);
    public List<AnimalInfoVO> selectDogProcessState(String date);


    // CAT
    public CatInfoVO selectCatCntStatusByDate(String date);
    public CatInfoVO selectAllCatCntByDate();
    public List<CatInfoVO> selectCatSexAnimalCnt(String date);
    public List<CatInfoVO> selectCatCntRegion(String date);
    public List<CatInfoVO> selectCatNeuterCnt(String date);
    public List<CatInfoVO> selectMonthCatCnt(String date);
    public List<CatInfoVO> selectCatProcessState(String date);


    // Other
    public OtherInfoVO selectOtherCntStatusByDate(String date);
    public OtherInfoVO selectAllOtherCntByDate();
    public List<OtherInfoVO> selectOtherSexAnimalCnt(String date);
    public List<OtherInfoVO> selectOtherCntRegion(String date);
    public List<OtherInfoVO> selectOtherNeuterCnt(String date);
    public List<OtherInfoVO> selectMonthOtherCnt(String date);
}
