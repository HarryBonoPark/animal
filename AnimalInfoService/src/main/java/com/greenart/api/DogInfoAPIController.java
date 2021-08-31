package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.mapper.DogInfoMapper;
import com.greenart.service.DogInfoService;
import com.greenart.vo.DogInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogInfoAPIController {
    @Autowired DogInfoService service;
    @Autowired DogInfoMapper mapper;
    //지역 별 데이터 가져오기
    @GetMapping("/api/regionDog")
    public Map<String, Object> getRegionDogInfo(@RequestParam @Nullable String region){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<DogInfoVO> vo = service.selectRegionDogInfo(region);
        
        char[] c = region.toCharArray();
        region = "%"+c[0]+"%"+c[1]+"%"+c[2]+"%";
        //System.out.println(region);

        resultMap.put("status", true);
        resultMap.put("dogList", vo);
        return resultMap;
    }
    //상세정보 가져오기
    @GetMapping("/api/dogDetailInfo/{seq}")
    public Map<String, Object> getDogDetailById(@PathVariable Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        DogInfoVO vo = service.selectDogInfoById(seq);

        resultMap.put("data", vo);

        return resultMap;
    }

}