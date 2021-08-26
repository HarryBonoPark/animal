package com.greenart.api;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.SupportService;
import com.greenart.vo.SupportVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportAPIController {
    @Autowired SupportService service;
    @PostMapping("/support/regist")
    public Map<String, Object> supportRegist(@RequestBody SupportVO vo){
        return service.insertSupport(vo);
    }
    //지역별 게시글 가져오기
    @GetMapping("/api/support")
    public Map<String, Object> selectSupportList(@RequestParam @Nullable String region){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<SupportVO> list = service.selectSupportList(region);
        resultMap.put("status", true);
        resultMap.put("data", list);
        return resultMap;
    }
    @DeleteMapping("/api/delete")
    public Map<String, Object> deleteSupport(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteSupport(seq);
        resultMap.put("message", "삭제되었습니다.");
        return resultMap;
    }
}
