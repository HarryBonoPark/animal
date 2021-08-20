package com.greenart.service;

import java.util.List;

import com.greenart.mapper.DogInfoMapper;
import com.greenart.vo.AnimalInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogInfoService {
    @Autowired DogInfoMapper mapper;
    public List<AnimalInfoVO> selectDogInfo(String date){
        return mapper.selectDogInfo(date);
    }
}
