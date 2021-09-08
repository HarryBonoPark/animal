package com.greenart.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.LostInfoService;
import com.greenart.vo.LostInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LostAPIController {
    @Autowired
    LostInfoService service;

    // 분실 동물 등록
    @PostMapping("/api/animal/lost")
    public Map<String, Object> postLostController(@RequestBody LostInfoVO vo) {
        return service.insertLostAnimalInfo(vo);
    }

    // 분실 동물 지역, 날짜별 검색
    @GetMapping("/api/lost/list")
    public Map<String, Object> getLostAnimalList(
        @RequestParam String region,
        @RequestParam @Nullable String startDate,
        @RequestParam @Nullable String endDate
    ) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sDt = formatter.parse(startDate);
        Date eDt = formatter.parse(endDate);

        List<LostInfoVO> list = service.selectLostAnimalList(region, sDt, eDt);

        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
    // 분실 동물 상세정보
    @GetMapping("/api/lost/detail")
    public Map<String, Object> getLostAnimalInfoDetail(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        LostInfoVO vo = service.selectLostAnimalInfoBySeq(seq);
        
        resultMap.put("status", true);
        resultMap.put("data", vo);

        return resultMap;
    }
    // 분실 동물 정보 삭제 (관리자 권한에서만)
    @DeleteMapping("/api/lost/delete")
    public Map<String, Object> deleteLostAnimalInfo(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.deleteLostAnimalInfo(seq);

        resultMap.put("message", "삭제되었습니다.");
        return resultMap;
    }
    // 분실 동물 정보 수정 (관지라 권한에서만)
    @PatchMapping("/api/lost/update")
    public Map<String, Object> updateLostAnimalInfo(@RequestBody LostInfoVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.updateLostAnimalInfo(vo);
        resultMap.put("status", true);
        resultMap.put("message", "수정되었습니다.");

        return resultMap;
    }
}
