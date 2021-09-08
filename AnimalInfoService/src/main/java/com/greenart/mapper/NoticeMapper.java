package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.NoticeVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
    public void insertNotice(NoticeVO vo);
    public List<NoticeVO> selectNotices(Integer offset, String keyword, Integer category);

    public NoticeVO selectNoticeByseq(Integer seq);
    public String getTitle(Integer seq);
    public String getCategoryName(Integer cate_seq);
    public String selectMemId(Integer seq);

    public List<NoticeVO> selectAllNotice();
}
