package com.greenart.mapper;

import java.util.Date;
import java.util.List;

import com.greenart.vo.LostImageVO;
import com.greenart.vo.LostInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LostInfoMapper {
    public void insertLostAnimalInfo(LostInfoVO vo);
    public void insertLostAnimalImage(LostImageVO vo);
    public String selectLostAnimalImagePath(String uri);

    public List<LostInfoVO> selectLostAnimalList(String region, Date startDate, Date endDate);
    public LostInfoVO selectLostAnimalInfoBySeq(Integer seq);
    public void deleteLostAnimalInfo(Integer seq);
}
