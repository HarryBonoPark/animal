package com.greenart.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.mapper.SupportMapper;
import com.greenart.vo.SupportVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportService {
    @Autowired SupportMapper mapper;
    //값 insert를 통해 가져오기
    public Map<String, Object> insertSupport(SupportVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.insertSupport(vo);

        resultMap.put("status", true);
        resultMap.put("message", "등록 성공");

        return resultMap;
    }
    //지역 선택에 따른 리스트 가져오기
    public List<SupportVO> selectSupportList(String region){
        return mapper.selectSupportList(region);
    }
    //삭제 클릭시 해당 seq값에 맞는 게시글 삭제
    public void deleteSupport(Integer seq){
        mapper.deleteSupport(seq);
    }
}
