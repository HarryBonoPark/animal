package com.greenart.api;


import java.util.Map;

import com.greenart.service.SupportService;
import com.greenart.vo.SupportVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportAPIController {
    @Autowired SupportService service;
    @PostMapping("/support/regist")
    public Map<String, Object> supportRegist(@RequestBody SupportVO vo){
        return service.insertSupport(vo);
    }
}
