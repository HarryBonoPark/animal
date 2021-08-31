package com.greenart.mapper;

import com.greenart.vo.LoginVO;
import com.greenart.vo.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoMapper {
    public void InsertMemberInfo(MemberInfoVO vo); //전체 데이터 넣어주기
    public Integer selectMemberById(String id); //아이디 중복값 체크
    public Integer selectMemberByEmail(String email); //이메일 중복값 체크
    public Integer memberLogin(LoginVO vo); //회원가입 정보 - 회원가입 된 사람인가?
    public MemberInfoVO selectMemberInfo(String id); //회원가입된 사람의 정보 가져오기
    
}
