package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.CenterInfoService;
import com.greenart.vo.CenterInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CenterAPIController {
    @Autowired
    CenterInfoService service;
    @GetMapping("/api/center")
    public Map<String, Object> getAnimalCenterInfo(
        @PathVariable @Nullable String region
    ) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<CenterInfoVO> list = service.selectCenterInfo(region);

        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
    @GetMapping("/api/center/cnt")
    public Map<String, Object> getCenterInfoCnt() {

        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    
        CenterInfoVO data = null;

        data = service.selectCenterInfoCnt();
    
        resultMap.put("status", true);
        resultMap.put("data", data);

        return resultMap;
    }
}