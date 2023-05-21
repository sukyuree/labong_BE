package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.MateBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MateBoardRepository {
    void save(MateBoard mateBoard);
    Optional<MateBoard> findById(Long id);
    void update(MateBoard mateBoard);
    void delete(Long id);
    List<MateBoard> findAll();
}
