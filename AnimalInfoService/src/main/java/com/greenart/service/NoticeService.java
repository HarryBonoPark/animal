package com.greenart.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.mapper.CategoryMapper;
import com.greenart.mapper.NoticeMapper;
import com.greenart.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
    @Autowired NoticeMapper mapper;
    @Autowired CategoryMapper c_mapper;

    public Map<String, Object> insertNotice(NoticeVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(vo.getTitle() == "" || vo.getTitle() == null){
            resultMap.put("status", "failed");
            resultMap.put("message", "공지 명이 입력되지 않았습니다.");
            return resultMap;
        }
        if(vo.getContent() == "" || vo.getContent() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "공지 내용이 입력되지 않았습니다.");
            return resultMap;
        }
        if(vo.getNi_cate_seq() == null){
            resultMap.put("status", "failed");
            resultMap.put("message", "카테고리가 선택되지 않았습니다.");
            return resultMap;
        }
        mapper.insertNotice(vo);

        resultMap.put("status", "success");
        resultMap.put("message", "공지사항이 등록되었습니다.");

        return resultMap;
    }

    public List<NoticeVO> selectNotices(Integer offset, String keyword, Integer category){
        if(offset == null) offset = 0;
        if(keyword == null) { keyword = "%%"; }
        else {keyword = "%"+keyword+"%";}

        List<NoticeVO> list = mapper.selectNotices(offset, keyword, category);

        for(int i=0; i<list.size(); i++){
            Integer cate_seq = list.get(i).getNi_cate_seq();
            String cate_name = c_mapper.selectCategoryName(cate_seq);
            list.get(i).setCate_name(cate_name);
        }
        return list;
    }

    public NoticeVO selectNoticeByseq(Integer seq){
        return mapper.selectNoticeByseq(seq);
    }

    public List<NoticeVO> selectAllNotice(){
        return mapper.selectAllNotice();
    }

}
