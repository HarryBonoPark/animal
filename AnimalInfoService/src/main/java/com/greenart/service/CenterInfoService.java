package com.greenart.service;

import java.util.List;

import com.greenart.mapper.CenterInfoMapper;
import com.greenart.vo.CenterInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterInfoService {
    @Autowired
    CenterInfoMapper mapper;
    public List<CenterInfoVO> selectCenterInfo(String region) {
        return mapper.selectCenterInfo(region);
    }
    public CenterInfoVO selectCenterInfoCnt() {
        CenterInfoVO data = mapper.selectCenterInfoCnt();

        Integer centerCnt = data.getCenterCnt();

        data.setCenterCnt(centerCnt);

        return data;
    }
}
