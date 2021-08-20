package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.DogInfoService;
import com.greenart.vo.AnimalInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogInfoAPIController {
    @Autowired DogInfoService service;
    @GetMapping("/api/dog/{date}")
    public Map<String, Object> getDogInfo(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        

        List<AnimalInfoVO> list = service.selectDogInfo(date);

        resultMap.put("status",true);
        resultMap.put("dogList",list);

        return resultMap;
    }
}
