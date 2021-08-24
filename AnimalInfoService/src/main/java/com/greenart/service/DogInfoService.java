package com.greenart.service;

import java.util.List;

import com.greenart.mapper.DogInfoMapper;
import com.greenart.vo.DogInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogInfoService {
    @Autowired DogInfoMapper mapper;
    public List<DogInfoVO> selectDogInfo(String date){
        return mapper.selectDogInfo(date);
    }
    public Integer selectCnt(){
        return mapper.selectCnt();
    }
    public DogInfoVO selectDogInfoById(Integer seq) {
        return mapper.selectDogInfoById(seq);
    }
    public List<DogInfoVO> selectRegionDogInfo(String region){
        return mapper.selectRegionDogInfo(region);
    }
}
