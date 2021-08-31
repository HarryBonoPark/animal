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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportAPIController {
    @Autowired SupportService service;
    //전체 데이터 넣어주기
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
    //삭제 기능
    @DeleteMapping("/api/delete")
    public Map<String, Object> deleteSupport(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteSupport(seq);
        resultMap.put("message", "삭제되었습니다.");
        return resultMap;
    }
    //수정하기 위해 입력된 값 가져오기
    @GetMapping("/api/support/get")
    public Map<String, Object> getSupport(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        SupportVO vo = service.selectSupportBySeq(seq);
        resultMap.put("status",true);
        resultMap.put("data",vo);
        return resultMap;
    }
    //수정하기
    @PatchMapping("/api/update")
    public Map<String, Object> supportUpdate(@RequestBody SupportVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.updateSupportList(vo);
        resultMap.put("status",true);
        resultMap.put("message","수정되었습니다");
        return resultMap;

    }
    //비밀번호 확인-같은 비밀번호가 있으면 1-true | 없으면 false
    @PostMapping("/api/check_pwd")
    public Boolean postCheckPwd(@RequestBody SupportVO vo) {
        Integer r = service.checkPassword(vo);
        if(r == 1) {
            return true;
        }
        return false;
    }

}
