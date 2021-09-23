package com.greenart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.greenart.service.CategoryService;
import com.greenart.service.MemberInfoService;
import com.greenart.service.NoticeService;
import com.greenart.vo.CategoryVO;
import com.greenart.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class noticeController {
    @Autowired CategoryService c_service;
    @Autowired NoticeService n_service;
    @Autowired MemberInfoService m_service;

    @GetMapping("/notice")
    public String getNotice(@RequestParam @Nullable Integer seq, @RequestParam @Nullable Integer status, Model model){
        List<CategoryVO> clist = c_service.selectCategoryAll();
        NoticeVO notice = n_service.selectNoticeByseq(seq);
        List<NoticeVO> nList = n_service.selectAllNotice();

        model.addAttribute("clist", clist);
        model.addAttribute("notice", notice);
        model.addAttribute("nList", nList);

        return "/notice/notice";
    }

    @GetMapping("/notice/nList")
    public String getNoticeList(@RequestParam @Nullable Integer seq, HttpSession session, Model model){
        List<CategoryVO> clist = c_service.selectCategoryAll();
        model.addAttribute("clist", clist);
        NoticeVO notice = n_service.selectNoticeByseq(seq);
        model.addAttribute("notice", notice);
        List<NoticeVO> nList = n_service.selectAllNotice();
        model.addAttribute("nList", nList);
        return "/notice/nList";
    }

    @GetMapping("/noticeDetail")
    public String getNoticeDetail(@RequestParam @Nullable Integer seq, Model model){
        NoticeVO notice = n_service.selectNoticeByseq(seq);
        model.addAttribute("notice", notice);
        
        return "/notice/detail";
    }
}
