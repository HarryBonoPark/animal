package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CalendarInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CalendarInfoMapper {
    public void insertCalendarInfo(CalendarInfoVO vo);
    public CalendarInfoVO selectCalendarById(Integer seq);
    public List<CalendarInfoVO> selectRegionList(String region);
}
