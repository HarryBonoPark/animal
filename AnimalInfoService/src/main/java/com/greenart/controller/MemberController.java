package com.greenart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/member/join")
    public String getMemberJoin(){
        return "/member/join";
    }
    @GetMapping("/member/login")
    public String getMemberLogin(){
        return "/member/login";
    }
    @GetMapping("/member/logout")
    public String getMemberLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
