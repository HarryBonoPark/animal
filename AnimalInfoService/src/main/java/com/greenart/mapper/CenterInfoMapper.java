package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CenterInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CenterInfoMapper {
    public List<CenterInfoVO> selectCenterInfo(String region);
    public CenterInfoVO selectCenterInfoCnt();
}
