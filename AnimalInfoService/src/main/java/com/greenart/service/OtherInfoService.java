package com.greenart.service;

import java.util.List;

import com.greenart.mapper.OtherInfoMapper;
import com.greenart.vo.OtherInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherInfoService {
    @Autowired OtherInfoMapper mapper;
    //기타 동물 가져오기
    public void insertOtherInfo(OtherInfoVO vo){
        mapper.insertOtherInfo(vo);
    }
    //지역별 기타동물
    public List<OtherInfoVO> selectRegionOtherInfo(String region){
        return mapper.selectRegionOtherInfo(region);
    }
    //기타동물 상세보기
    public OtherInfoVO selectOtherById(Integer seq){
        return mapper.selectOtherById(seq);
    }
}
