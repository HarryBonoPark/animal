package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.SupportVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupportMapper {
    public void insertSupport(SupportVO vo);
    public List<SupportVO> selectSupportList(String region);
    public void deleteSupport(Integer seq);
}
