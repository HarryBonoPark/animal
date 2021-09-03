package com.greenart.mapper;

import com.greenart.vo.LoginVO;
import com.greenart.vo.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoMapper {
    //회원가입
    public void InsertMemberInfo(MemberInfoVO vo); //전체 데이터 넣어주기
    public Integer selectMemberById(String id); //아이디 중복값 체크
    public Integer selectMemberByEmail(String email); //이메일 중복값 체크
    // 로그인
    public Integer memberLogin(LoginVO vo); //회원가입 정보 - 회원가입 된 사람인가? 0과 1값으로. 아니면 회원가입으로.
    public MemberInfoVO selectMemberInfo(String id); //회원가입된 사람의 정보 가져오기
    //수정하기
    // public MemberInfoVO selectMemberByseq(Integer seq); //전체 정보 seq로 가져오기
    // public void updateMemberInfo(MemberInfoVO vo); // 회원정보 수정
}
