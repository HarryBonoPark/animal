package com.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatController {
    @GetMapping("/cat")
    public String getCat() {
        return "/animal/cat";
    }
}
