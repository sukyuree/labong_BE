package com.comealone.jeju.service.service;

import com.comealone.jeju.domain.model.User;
import com.comealone.jeju.domain.repository.FollowRepository;
import com.comealone.jeju.domain.repository.UserRepository;
import com.comealone.jeju.util.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public List<String> getMyFollower(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return followRepository.findAllFollowerById(user.getId());
    }

    public List<String> getMyFollowing(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return followRepository.findAllFollowingById(user.getId());
    }

    @Transactional
    public void addFollowing(String nickName){
        User followingUser = userRepository.findByNickName(nickName).orElse(null);
        User followedUser = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        followRepository.save(followedUser.getId(), followingUser.getId());
    }
}
