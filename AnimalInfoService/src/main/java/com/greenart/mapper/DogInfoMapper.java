package com.greenart.mapper;

import java.util.List;
import com.greenart.vo.DogInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DogInfoMapper {
    public List<DogInfoVO> selectRegionDogInfo(String region);
    public DogInfoVO selectDogInfoById(Integer seq);

}
