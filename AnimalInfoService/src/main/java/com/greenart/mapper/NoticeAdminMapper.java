package com.greenart.mapper;

import com.greenart.vo.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeAdminMapper {
    public MemberInfoVO selectAdminStatus(Integer status);
}
