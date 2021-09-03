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
    public void insertCenterInfo(CenterInfoVO vo) {
        mapper.insertCenterInfo(vo);
    }
    public List<CenterInfoVO> selectCenterInfoByRegion(String region) {
        return mapper.selectCenterInfoByRegion(region);
    }
    public CenterInfoVO selectCenterInfoCntAll() {
        CenterInfoVO data = mapper.selectCenterInfoCntAll();
        Integer centerCnt = data.getCenterCnt();
        data.setCenterCnt(centerCnt);

        return data;
    }
    public CenterInfoVO selectCenterInfoBySeq(Integer seq) {
        return mapper.selectCenterInfoBySeq(seq);
    }
}
