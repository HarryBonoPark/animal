package com.greenart.api;

import java.util.Map;

import com.greenart.service.LostInfoService;
import com.greenart.vo.LostInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LostAPIController {
    @Autowired
    LostInfoService service;

    @PostMapping("/api/animal/lost")
    public Map<String, Object> postLostController(@RequestBody LostInfoVO vo) {
        return service.insertLostAnimalInfo(vo);
    }
}
