package com.greenart.mapper;

import com.greenart.vo.SupportVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupportMapper {
    public void insertSupport(SupportVO vo);
}
