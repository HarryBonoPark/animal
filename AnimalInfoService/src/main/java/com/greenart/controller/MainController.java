package com.greenart.controller;

import com.greenart.service.AnimalInfoService;
import com.greenart.vo.AnimalInfoVO;
import com.greenart.vo.CatInfoVO;
import com.greenart.vo.OtherInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired AnimalInfoService service;
    
    @GetMapping("/")
    public String getMain(Model model) {

        AnimalInfoVO cnt = service.selectTodayCntStatusByDate();
        AnimalInfoVO allCnt = service.selectTodayAllCntByDate();
        CatInfoVO c_cnt = service.selectTodayCatCntStatusByDate();
        CatInfoVO c_allCnt = service.selectTodayAllCatCntByDate();
        OtherInfoVO o_cnt = service.selectTodayOtherCntStatusByDate();
        OtherInfoVO o_allCnt = service.selectTodayAllOtherCntByDate();
                
        model.addAttribute("cnt", cnt);
        model.addAttribute("allCnt", allCnt);
        model.addAttribute("c_cnt", c_cnt);
        model.addAttribute("c_AllCnt", c_allCnt);
        model.addAttribute("o_cnt", o_cnt);
        model.addAttribute("o_allCnt", o_allCnt);

        return "/index";
    }
}
