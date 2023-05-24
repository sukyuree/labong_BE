package com.comealone.jeju.domain.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.comealone.jeju.domain.model.User;

@Mapper
public interface UserRepository{
	Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(String userId);
    Optional<User> findByNickName(String nickName);
    void save(User user);
    void update(User user);
    void delete(Long id);
}
