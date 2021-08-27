package com.greenart.controller;

import com.greenart.service.AnimalInfoService;
import com.greenart.vo.AnimalInfoVO;
import com.greenart.vo.CatInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired AnimalInfoService service;
    
    @GetMapping("/")
    public String getMain(Model model) {
        // AnimalInfoVO vo = service.selectTodayAnimalInfo();
        // model.addAttribute("animalInfo", vo);
        // AnimalInfoVO vo2 = service.selectTodayAccAnimalInfo();
        // model.addAttribute("Accanimal", vo2);

        AnimalInfoVO cnt = service.selectTodayCntStatusByDate();
        AnimalInfoVO allCnt = service.selectTodayAllCntByDate();
        CatInfoVO c_cnt = service.selectTodayCatCntStatusByDate();
        CatInfoVO c_AllCnt = service.selectTodayAllCatCntByDate();
                
        model.addAttribute("cnt", cnt);
        model.addAttribute("allCnt", allCnt);
        model.addAttribute("c_cnt", c_cnt);
        model.addAttribute("c_AllCnt", c_AllCnt);

        return "/index";
    }
}
