package com.greenart.mapper;

import com.greenart.vo.OtherInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OtherInfoMapper {
    public void insertOtherInfo(OtherInfoVO vo);
}