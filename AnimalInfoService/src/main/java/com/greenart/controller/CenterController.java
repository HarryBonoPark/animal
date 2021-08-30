package com.greenart.controller;

import com.greenart.service.CenterInfoService;
import com.greenart.vo.CenterInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CenterController {
    @Autowired
    CenterInfoService service;

    @GetMapping("/center")
    public String getCenter() {
        return "/center/center";
    }
    @GetMapping("/center/detail")
    public String getCenterDetail(@RequestParam Integer seq, Model model) {
        CenterInfoVO vo = service.selectCenterInfoBySeq(seq);
        model.addAttribute("detail", vo);

        return "/center/detail";
    }
}
