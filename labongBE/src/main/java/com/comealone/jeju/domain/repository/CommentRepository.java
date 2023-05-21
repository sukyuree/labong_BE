package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.Comment;
import com.comealone.jeju.service.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    List<CommentDto> findAllByBoardId(Long id);
    void save(Comment comment);
}
