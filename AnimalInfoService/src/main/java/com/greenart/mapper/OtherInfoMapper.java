package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.OtherInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OtherInfoMapper {
    public void insertOtherInfo(OtherInfoVO vo);
    public List<OtherInfoVO> selectRegionOtherInfo(String region);
    public OtherInfoVO selectOtherById(Integer seq);
}
