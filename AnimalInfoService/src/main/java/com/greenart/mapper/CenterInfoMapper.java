package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.AnimalInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CenterInfoMapper {
    public List<AnimalInfoVO> selectCenterInfo(String processState);
}
