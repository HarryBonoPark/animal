package com.greenart.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.mapper.LostInfoMapper;
import com.greenart.vo.LostImageVO;
import com.greenart.vo.LostInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LostInfoService {
    @Autowired
    LostInfoMapper mapper;

    public Map<String, Object> insertLostAnimalInfo(LostInfoVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        mapper.insertLostAnimalInfo(vo);

        resultMap.put("status", true);
        resultMap.put("message", "분실 신고가 등록되었습니다.");

        return resultMap;
    }

    public void insertLostAnimalImage(LostImageVO vo) {
        mapper.insertLostAnimalImage(vo);
    }

    public String selectLostAnimalImagePath(String uri) {
        return mapper.selectLostAnimalImagePath(uri);
    }

    public List<LostInfoVO> selectLostAnimalList(String region, Date startDate, Date endDate) {
        return mapper.selectLostAnimalList(region, startDate, endDate);
    }

    public LostInfoVO selectLostAnimalInfoBySeq(Integer seq) {
        return mapper.selectLostAnimalInfoBySeq(seq);
    }

    public void deleteLostAnimalInfo(Integer seq) {
        mapper.deleteLostAnimalInfo(seq);
    }

    public void updateLostAnimalInfo(LostInfoVO vo) {
        mapper.updateLostAnimalInfo(vo);
    }
}
