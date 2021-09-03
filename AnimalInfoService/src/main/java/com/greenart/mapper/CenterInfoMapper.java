package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CenterInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CenterInfoMapper {
    public void insertCenterInfo(CenterInfoVO vo);
    public List<CenterInfoVO> selectCenterInfoByRegion(String region);
    public CenterInfoVO selectCenterInfoCntAll();
    public CenterInfoVO selectCenterInfoBySeq(Integer seq);
}
