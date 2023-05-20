package com.comealone.jeju.service.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FollowRes extends BaseResponse{
	List<String> follower;

    public FollowRes(String msg, Integer status, List<String> follower){
        super(msg, status);
        this.follower=follower;
    }
}
