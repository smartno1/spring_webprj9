package com.project.web_prj.reply.repository;

import com.project.web_prj.common.paging.Page;
import com.project.web_prj.reply.domain.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    //댓글 입력
    boolean save(Reply reply);

    //댓글 수정
    boolean modify(Reply reply);

    //댓글 삭제
    boolean remove(Long replyNo);

    //댓글 전체 삭제
    boolean removeAll(Long boardNo);

    //댓글 개별 조회
    Reply findOne(Long replyNo);

    //댓글 목록 조회
    List<Reply> findAll(@Param("boardNo") Long boardNo  // 두 객체에 같은 필드명이 존재 -> 충돌 -> 식별자를 부여해 해결.
            , @Param("page") Page page);

    // 댓글 수 조회
    int getReplyCount(Long boardNo);
}
