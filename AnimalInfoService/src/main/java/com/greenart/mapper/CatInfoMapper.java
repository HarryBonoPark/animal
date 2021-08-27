package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CatInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatInfoMapper {
    public void insertCatInfo(CatInfoVO vo);
    public List<CatInfoVO> selectCatInfo(String region);
    public CatInfoVO selectCatDetailInfoBySeq(Integer seq);
}
