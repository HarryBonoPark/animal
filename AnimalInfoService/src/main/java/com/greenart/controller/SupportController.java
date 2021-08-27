package com.greenart.controller;

import com.greenart.service.SupportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SupportController {
    @Autowired
    SupportService service;
    @GetMapping("/support")
    public String getSupport(@RequestParam @Nullable Integer seq, Model model){

        if(seq == null) {
            model.addAttribute("status", false);
        }
        else {
            model.addAttribute("status", true);
            model.addAttribute("data", service.selectSupportBySeq(seq));
        }
        return "/support/support";
    }
}
