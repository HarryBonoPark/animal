package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.CenterInfoService;
import com.greenart.vo.CenterInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CenterAPIController {
    @Autowired
    CenterInfoService service;
    @GetMapping("/api/center")
    public Map<String, Object> getAnimalCenterInfo() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<CenterInfoVO> list = service.selectCenterInfo();
        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
}
