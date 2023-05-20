package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowRepository {
    List<String> findAllFollowerById(Long id);
    List<String> findAllFollowingById(Long id);
    void save(Long followerId, Long followingId);
}
