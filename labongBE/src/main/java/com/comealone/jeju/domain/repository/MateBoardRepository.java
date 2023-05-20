package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.MateBoard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MateBoardRepository {
    void save(MateBoard mateBoard);
}
