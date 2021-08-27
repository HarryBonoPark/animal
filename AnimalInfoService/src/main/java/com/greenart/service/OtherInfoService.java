package com.greenart.service;

import com.greenart.mapper.OtherInfoMapper;
import com.greenart.vo.OtherInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherInfoService {
    @Autowired OtherInfoMapper mapper;
    public void insertOtherInfo(OtherInfoVO vo){
        mapper.insertOtherInfo(vo);
    }
}
