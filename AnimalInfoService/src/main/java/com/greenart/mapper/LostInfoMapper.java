package com.greenart.mapper;

import com.greenart.vo.LostImageVO;
import com.greenart.vo.LostInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LostInfoMapper {
    public void insertLostAnimalInfo(LostInfoVO vo);
    public void insertLostAnimalImage(LostImageVO vo);
}
