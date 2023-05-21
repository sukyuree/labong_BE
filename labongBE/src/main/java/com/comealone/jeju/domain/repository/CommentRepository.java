package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    List<Comment> findAllByBoardId(Long id);
}
