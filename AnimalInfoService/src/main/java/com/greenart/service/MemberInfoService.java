package com.greenart.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.greenart.mapper.MemberInfoMapper;
import com.greenart.utils.AESAlgorithm;
import com.greenart.vo.LoginVO;
import com.greenart.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoService {
    @Autowired MemberInfoMapper mapper;
    public Map < String, Object > InsertMemberInfo(MemberInfoVO vo) {
        Map < String, Object > resultMap = new LinkedHashMap < String, Object > ();
        //아이디
        boolean duplicated = isDoplicatedId(vo.getId());
        if (duplicated) {
            resultMap.put("status", false);
            resultMap.put("message", "이미 등록된 아이디가 존재합니다.");
            return resultMap;
        }
        //이메일
        boolean email_duplicated = isDoplicatedEmail(vo.getEmail());
        if (email_duplicated) {
            resultMap.put("status", false);
            resultMap.put("message", "이미 등록된 이메일이 존재합니다.");
            return resultMap;
        }
        String pwd = vo.getPassword();
        try {
            pwd = AESAlgorithm.Encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vo.setPassword(pwd);

        mapper.InsertMemberInfo(vo);

        resultMap.put("status", true);
        resultMap.put("message", "회원가입이 완료되었습니다.");

        return resultMap;
    }
    //아이디 중복
    public boolean isDoplicatedId(String id) {
        //0보다 크면 중복
        return mapper.selectMemberById(id) > 0;
    }
    //이메일 중복
    public boolean isDoplicatedEmail(String email) {
        //0보다 크면 중복
        return mapper.selectMemberByEmail(email) > 0;
    }


    //로그인 할 때 1이면 로그인 되야하지만 아니면 오류.
    public Map < String, Object > memberLogin(LoginVO vo) {
        Map < String, Object > resultMap = new LinkedHashMap < String, Object > ();
        String pwd = vo.getPwd();
        try {
            pwd = AESAlgorithm.Encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vo.setPwd(pwd);
        Integer result = mapper.memberLogin(vo);
        if (result == 1) {
            resultMap.put("status", true);
            //회원가입 가져오기
            MemberInfoVO member = mapper.selectMemberInfo(vo.getId());
            resultMap.put("member", member);
        } else {
            resultMap.put("status", false);
            resultMap.put("message", "아이디 혹은 비밀번호 오류입니다.");
        }
        return resultMap;
    }
    //전체 데이터 가져오기
    // public MemberInfoVO selectMemberByseq(Integer seq){
    //     return mapper.selectMemberByseq(seq);
    // }
    //수정 사항 
    // public void updateMemberInfo(MemberInfoVO vo){
    //     mapper.updateMemberInfo(vo);
    // }

}