package com.greenart.service;

import java.util.List;

import com.greenart.mapper.CategoryMapper;
import com.greenart.vo.CategoryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired CategoryMapper mapper;

    public boolean addCategory(String name){
        Integer n = mapper.isDuplicateCategory(name);
        if(n != 0){
            return false;
        }
        mapper.insertCategory(name);
        return true;
    }
    public List<CategoryVO> selectCategoryAll(){
        List<CategoryVO> list = mapper.selectCategoryAll();
        for(int i=0; i<list.size(); i++){
            Integer cnt = mapper.selectCateCnt(list.get(i).getCate_seq());
            list.get(i).setCate_cnt(cnt);
        }
        return list;
    }
    public void deleteCategory(Integer seq){
        mapper.deleteCategory(seq);
    }
}
