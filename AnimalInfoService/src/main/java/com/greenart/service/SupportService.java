package com.greenart.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.greenart.mapper.SupportMapper;
import com.greenart.vo.SupportVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportService {
    @Autowired SupportMapper mapper;
    public Map<String, Object> insertSupport(SupportVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.insertSupport(vo);

        resultMap.put("status", true);
        resultMap.put("message", "등록 성공");

        return resultMap;
    }
}
