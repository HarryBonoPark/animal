package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.mapper.DogInfoMapper;
import com.greenart.service.DogInfoService;
import com.greenart.vo.AnimalInfoVO;
import com.greenart.vo.DogInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogInfoAPIController {
    @Autowired DogInfoService service;
    @Autowired DogInfoMapper mapper;
    @GetMapping("/api/dog/{date}")
    public Map<String, Object> getDogInfo(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        List<DogInfoVO> list = service.selectDogInfo(date);

        resultMap.put("status",true);
        resultMap.put("dogList",list);

        Integer allCnt = service.selectCnt();
        if(allCnt==null) allCnt=0;
        resultMap.put("allCnt", allCnt);

        Integer page = (int)Math.ceil(allCnt/12);
        resultMap.put("page", page);

        return resultMap;
    }
    @GetMapping("/api/dogDetailInfo/{}")
    public Map<String, Object> getDogDetail(@PathVariable String date){
    Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

    List<DogInfoVO> list = service.selectDogInfo(date);

    resultMap.put("status",true);
    resultMap.put("dogList",list);
    return resultMap;
    }
    @GetMapping("/api/dogDetailInfo/{seq}")
    public Map<String, Object> getDogDetailById(@PathVariable Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        DogInfoVO vo = service.selectDogInfoById(seq);

        resultMap.put("data", vo);

        return resultMap;
    }
}