package com.comealone.jeju.service.request;

import com.comealone.jeju.domain.model.Follow;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FollowReq {
    @NotNull
    String nickName;

    public Follow toFollowModel(Long follower, Long following){
        Follow follow = Follow.builder()
                .follower(follower)
                .following(following)
                .build();
        return follow;
    }
}
