package com.greenart.controller;

import java.text.DecimalFormat;

import com.greenart.service.AnimalInfoService;
import com.greenart.vo.AnimalInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired AnimalInfoService service;
    
    @GetMapping("/")
    public String getMain(Model model) {
        AnimalInfoVO vo = service.selectTodayAnimalInfo();
        model.addAttribute("animalInfo", vo);
        // AnimalInfoVO vo2 = service.selectTodayAccAnimalInfo();
        // model.addAttribute("Accanimal", vo2);

        Integer cnt = service.selectCntStatusByDate();
        Integer allCnt = service.selectAllCntByDate();
        
        DecimalFormat df = new DecimalFormat("###,###");
        String formatCnt = df.format(cnt);
        String formatAllCnt = df.format(allCnt);
        
        model.addAttribute("cnt", formatCnt);
        model.addAttribute("allCnt", formatAllCnt);

        return "/index";
    }
}
