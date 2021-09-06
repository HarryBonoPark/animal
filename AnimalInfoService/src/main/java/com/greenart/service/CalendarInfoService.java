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
    //예약 정보 저장하기
    public Map<String, Object> insertCalendarInfo(CalendarInfoVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            mapper.insertCalendarInfo(vo);

        resultMap.put("status",true);
        resultMap.put("message","예약 완료");
        
        return resultMap;
    }
    //예약 정보 중 center 리스트 가져오기
    public List<CalendarInfoVO> selectRegionList(String region){
        return mapper.selectRegionList(region);
    }

    //지역, 센터별 예약 정보 가져오기
    public List<CalendarInfoVO> selectCalendarById(String region, String careNm){
        return mapper.selectCalendarById(region, careNm);
    }
}
