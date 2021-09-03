package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.NoticeService;
import com.greenart.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeAPIController {
    @Autowired NoticeService service;
    
    @PostMapping("/api/notice/add")
    public Map<String, Object> postNoticeAdd(@RequestBody NoticeVO vo){
        return service.insertNotice(vo);
    }

    @GetMapping("/api/notice/list")
    public Map<String, Object> getNoticeList(
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable Integer category
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<NoticeVO> list = service.selectNotices(offset, keyword, category);
        resultMap.put("data", list);
        
        return resultMap;
    }
    @GetMapping("/api/notice/get")
    public Map<String, Object> getNotice(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        NoticeVO vo = service.selectNoticeByseq(seq);
        resultMap.put("status", true);
        resultMap.put("data", vo);

        return resultMap;
    }
}
