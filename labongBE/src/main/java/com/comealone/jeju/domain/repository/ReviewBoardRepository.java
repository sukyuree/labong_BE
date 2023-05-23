package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.ReviewBoard;
import com.comealone.jeju.service.dto.ReviewBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReviewBoardRepository {
    void save(ReviewBoard reviewBoard);
    Optional<ReviewBoardDto> findById(Long id);
    void update(ReviewBoard reviewBoard);
    void delete(Long id);
    List<ReviewBoardDto> findAll();
}
