package com.greenart.controller;

import com.greenart.service.LostInfoService;
import com.greenart.vo.LostInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LostController {
    @Autowired
    LostInfoService service;

    @GetMapping("/lost")
    public String getLostAnimal(Model model) {
        return "/animal/lost";
    }

    @GetMapping("/lost/list")
    public String getLostAnimalList() {
        return "/animal/lostList";
    }

    @GetMapping("/lost/detail")
    public String getLostAnimalDetail(@RequestParam Integer seq, Model model) {
        LostInfoVO vo = service.selectLostAnimalInfoBySeq(seq);
        model.addAttribute("detail", vo);

        return "/animal/lostDetail";
    }
}
