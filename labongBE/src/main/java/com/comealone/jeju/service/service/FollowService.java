package com.comealone.jeju.service.service;

import com.comealone.jeju.domain.model.User;
import com.comealone.jeju.domain.repository.FollowRepository;
import com.comealone.jeju.domain.repository.UserRepository;
import com.comealone.jeju.service.request.FollowReq;
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

    private User currentUser(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return user;
    }
    public List<String> getMyFollower(){
        User user = currentUser();
        return followRepository.findAllFollowerById(user.getId());
    }

    public List<String> getMyFollowing(){
        User user = currentUser();
        return followRepository.findAllFollowingById(user.getId());
    }

    @Transactional
    public void addFollowing(FollowReq followReq){
        User followingUser = userRepository.findByNickName(followReq.getNickName()).orElse(null);
        User followedUser = currentUser();

        followRepository.save(followReq.toFollowModel(followedUser.getId(), followingUser.getId()));
    }
}
