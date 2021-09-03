package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.CalendarInfoService;
import com.greenart.vo.CalendarInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarInfoAPIController {
    @Autowired CalendarInfoService service;
    //예약 저장
    @PostMapping("/calendar/add")
    public Map<String, Object> insertCalendarInfo(@RequestBody CalendarInfoVO vo){
        return service.insertCalendarInfo(vo);
    }
    //예약 정보 가져오기
    @GetMapping("/calendar/list/{seq}")
    public Map<String, Object> selectCalendarById(@PathVariable Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        CalendarInfoVO vo = service.selectCalendarById(seq);
        
        resultMap.put("status",true);
        resultMap.put("data",vo);

        return resultMap;
    }
    //지역별 center가져오기
    @GetMapping("/calendar/region")
    public Map<String, Object> selectRegionList(@RequestParam @Nullable String region, Model model){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<CalendarInfoVO> list = service.selectRegionList(region);
        
        model.addAttribute("list",list);

        resultMap.put("status", true);
        resultMap.put("data", list);

        char[] c = region.toCharArray();
        region = "%"+c[0]+"%"+c[1]+"%"+c[2]+"%";

        return resultMap;
    }
}
