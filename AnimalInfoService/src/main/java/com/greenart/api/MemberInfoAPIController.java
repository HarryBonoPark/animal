package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.greenart.service.MemberInfoService;
import com.greenart.vo.LoginVO;
import com.greenart.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberInfoAPIController {
    @Autowired MemberInfoService service;
    //회원가입
    @PostMapping("/member/join")
    public Map<String, Object> memberJoin(@RequestBody MemberInfoVO vo){
        return service.InsertMemberInfo(vo);
    }
    //아이디 중복 여부 체크
    @GetMapping("/member/chk_id")
        public Map<String, Object> getIdChk(@RequestParam String id){
            Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            if(service.isDoplicatedId(id)){
                resultMap.put("status",false);
                resultMap.put("message","["+id+"] 는 존재하는 아이디 입니다.");
                return resultMap;
            }
            resultMap.put("status",true);
            resultMap.put("message","["+id+"] 는 사용할 수 있습니다.");
            return resultMap;
        }
        //이메일 중복 여부 체크
        @GetMapping("/member/chk_email")
        public Map<String, Object> getEmailChk(@RequestParam String email){
            Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            if(service.isDoplicatedEmail(email)){
                resultMap.put("status",false);
                resultMap.put("message","["+email+"] 는 존재하는 이메일 입니다.");
                return resultMap;
            }
            resultMap.put("status",true);
            resultMap.put("message","["+email+"] 는 사용할 수 있습니다.");
            return resultMap;
        }
        @PostMapping("/member/login")
        public Map<String, Object> postMemberLogin(@RequestBody LoginVO vo, HttpSession session){
            Map<String, Object> resultMap = service.memberLogin(vo);
            session.setAttribute("member",resultMap.get("member"));
            return resultMap;
        }
}
