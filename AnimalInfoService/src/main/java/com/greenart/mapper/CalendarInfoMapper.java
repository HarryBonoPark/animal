package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CalendarInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CalendarInfoMapper {
    public void insertCalendarInfo(CalendarInfoVO vo); //예약정보 저장
    public List<CalendarInfoVO> selectRegionList(String region); //지역별 center 리스트 가져오기
    public List<CalendarInfoVO> selectCalendarById(String region, String careNm); //center별 예약 정보 가져오기
}
