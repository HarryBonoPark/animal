package com.greenart.service;

import com.greenart.mapper.AnimalInfoMapper;
import com.greenart.vo.AnimalInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalInfoService {
    @Autowired
    AnimalInfoMapper mapper;
    public void insertAnimalInfo(AnimalInfoVO vo) {
        mapper.insertAnimalInfo(vo);
    }
}
