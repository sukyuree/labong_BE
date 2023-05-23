package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.AttractionLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AttractionLikeRepository {
    Optional<AttractionLike> findByUserAndAttraction(Long userId, Long attractionId);
    void save(AttractionLike attractionLike);
    void delete(Long userId, Long attractionId);
    int countByAttraction(Long attractionId);
}
