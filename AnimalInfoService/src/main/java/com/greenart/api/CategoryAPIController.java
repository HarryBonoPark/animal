package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.CategoryService;
import com.greenart.vo.CategoryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryAPIController {
    @Autowired CategoryService service;

    @GetMapping("/api/category/add")
    public Map<String, Object> cateApiAdd(@RequestParam String name){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        boolean r = service.addCategory(name);
        if(r){
            resultMap.put("status", r);
            resultMap.put("message", "["+name+"] 카테고리 추가함");
        } else {
            resultMap.put("status", r);
            resultMap.put("message", "["+name+"] 카테고리 이미 존재함");
        }
        return resultMap;
    }

    @GetMapping("/api/category/list")
    public Map<String, Object> getCategoryList(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<CategoryVO> list = service.selectCategoryAll();
        resultMap.put("data", list);

        return resultMap;
    }

    @DeleteMapping("/api/category/delete")
    public Map<String, Object> deleteCategory(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteCategory(seq);

        resultMap.put("message", "삭제완료");
        return resultMap;
    }
}
