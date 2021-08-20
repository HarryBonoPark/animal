package com.greenart.mapper;

import com.greenart.vo.AnimalInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimalInfoMapper {
    public void insertAnimalInfo(AnimalInfoVO vo);
}
