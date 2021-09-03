package com.greenart.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.mapper.CalendarInfoMapper;
import com.greenart.vo.CalendarInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarInfoService {
    @Autowired CalendarInfoMapper mapper;
    public Map<String, Object> insertCalendarInfo(CalendarInfoVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            mapper.insertCalendarInfo(vo);

        resultMap.put("status",true);
        resultMap.put("message","예약 완료");
        
        return resultMap;
    }
    public CalendarInfoVO selectCalendarById(Integer seq){
        return mapper.selectCalendarById(seq);
    }
    public List<CalendarInfoVO> selectRegionList(String region){
        return mapper.selectRegionList(region);
    }
}
