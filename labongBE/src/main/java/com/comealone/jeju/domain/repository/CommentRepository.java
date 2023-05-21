package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.Comment;
import com.comealone.jeju.service.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommentRepository {
    List<CommentDto> findAllByBoardId(Long boardId);
    Optional<Comment> findById(Long commentId);
    void save(Comment comment);
    void update(Comment comment);
    void delete(Long id);
}
