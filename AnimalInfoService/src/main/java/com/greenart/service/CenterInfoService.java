package com.greenart.service;

import java.util.List;

import com.greenart.mapper.CenterInfoMapper;
import com.greenart.vo.AnimalInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterInfoService {
    @Autowired
    CenterInfoMapper mapper;
    public List<AnimalInfoVO> selectCenterInfo(String processState) {
        return mapper.selectCenterInfo(processState);
    }
}
