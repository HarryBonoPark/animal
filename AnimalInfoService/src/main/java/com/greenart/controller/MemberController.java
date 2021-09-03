package com.greenart.controller;

import javax.servlet.http.HttpSession;

import com.greenart.service.CalendarInfoService;
import com.greenart.service.MemberInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {
    @Autowired CalendarInfoService service;
    @Autowired MemberInfoService m_service;
    //회원가입
    @GetMapping("/member/join")
    public String getMemberJoin(){
        return "/member/join";
    }
    //로그인
    @GetMapping("/member/login")
    public String getMemberLogin(){
        return "/member/login";
    }
    //로그아웃
    @GetMapping("/member/logout")
    public String getMemberLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    //캘린더 부르기
    @RequestMapping("/member/calendar")
    public String Calendar() {
    return "/member/calendar";
    }
    
}
