package com.greenart.service;

import java.util.List;

import com.greenart.mapper.DogInfoMapper;
import com.greenart.vo.DogInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogInfoService {
    @Autowired DogInfoMapper mapper;
    public List<DogInfoVO> selectRegionDogInfo(String region){
        return mapper.selectRegionDogInfo(region);
    }
    public DogInfoVO selectDogInfoById(Integer seq) {
        return mapper.selectDogInfoById(seq);
    }
}
