package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.ReviewLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ReviewLikeRepository {
    Optional<ReviewLike> findByUserAndReview(Long userId, Long reviewId);
    void save(ReviewLike reviewLike);
    void delete(Long userId, Long reviewId);
    int countByReview(Long reviewId);
}
