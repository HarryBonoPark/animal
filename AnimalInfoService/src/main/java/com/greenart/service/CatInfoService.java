package com.greenart.service;

import java.util.List;

import com.greenart.mapper.CatInfoMapper;
import com.greenart.vo.CatInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatInfoService {
    @Autowired 
    CatInfoMapper mapper;
    public void insertCatInfo(CatInfoVO vo) {
        mapper.insertCatInfo(vo);
    }
    public List<CatInfoVO> selectCatInfo(String region) {
        return mapper.selectCatInfo(region);
    }
    public CatInfoVO selectCatDetailInfoBySeq(Integer seq) {
        return mapper.selectCatDetailInfoBySeq(seq);
    }
}