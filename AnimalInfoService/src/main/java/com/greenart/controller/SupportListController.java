package com.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportListController {
    @GetMapping("/support/list")
    public String getSupport(){
        return "/support/supportList";
    }
}
