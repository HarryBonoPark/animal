package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.SupportVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupportMapper {
    public void insertSupport(SupportVO vo); //입력된 값 넣어주기
    public List<SupportVO> selectSupportList(String region); //전체 리스트 보여주기
    public void deleteSupport(Integer seq); //삭제 기능
    public SupportVO selectSupportBySeq(Integer seq); //선택된 것 보여주기
    public void updateSupportList(SupportVO vo); //수정된 사항 업데이트
    public Integer checkPassword(SupportVO vo); // 비밀번호 확인하기 위해 vo가져오기
}
