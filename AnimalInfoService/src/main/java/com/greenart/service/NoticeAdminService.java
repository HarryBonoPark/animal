package com.greenart.service;

import com.greenart.mapper.NoticeAdminMapper;
import com.greenart.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeAdminService {
    @Autowired NoticeAdminMapper mapper;

    public MemberInfoVO selectAdminStatus(Integer status){
        return mapper.selectAdminStatus(status);
    }
}
