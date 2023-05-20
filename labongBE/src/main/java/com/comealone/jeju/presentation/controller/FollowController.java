package com.comealone.jeju.presentation.controller;

import com.comealone.jeju.service.request.FollowReq;
import com.comealone.jeju.service.response.BaseResponse;
import com.comealone.jeju.service.response.FollowRes;
import com.comealone.jeju.service.service.FollowService;
import com.comealone.jeju.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;
    private final UserService userService;
    @GetMapping("/follower")
    public ResponseEntity<? extends BaseResponse> getFollower(){
        List<String> follower = followService.getMyFollower();
        return ResponseEntity.status(200).body(new FollowRes("팔로워 조회가 완료되었습니다.",200,follower));
    }

    @GetMapping("/following")
    public ResponseEntity<? extends BaseResponse> getFollowing(){
        List<String> following = followService.getMyFollowing();
        return ResponseEntity.status(200).body(new FollowRes("팔로잉 조회가 완료되었습니다.",200,following));
    }

    @PostMapping("/following")
    public ResponseEntity<? extends BaseResponse> addFollower(@RequestBody FollowReq followReq){
        if(!userService.isExistNickName(followReq.getNickName()))
            return ResponseEntity.status(404).body(new BaseResponse("존재하지 않는 사용자입니다.",404));
        followService.addFollowing(followReq.getNickName());
        return ResponseEntity.status(201).body(new BaseResponse("팔로우가 완료 되었습니다.",201));
    }
}
