package com.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LostController {
    @GetMapping("/lost")
    public String getLostAnimal(Model model) {
        return "/animal/lost";
    }

    @GetMapping("/lost/list")
    public String getLostAnimalList() {
        return "/animal/lostList";
    }
}
