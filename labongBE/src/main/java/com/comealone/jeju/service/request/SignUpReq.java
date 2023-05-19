package com.comealone.jeju.service.request;

import com.comealone.jeju.domain.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpReq {
	String userId;
	String userPw;
	String nickName;
	String email;
	String profileImg;
    public User toUserModel() {
        User user = User.builder()
                .userId(this.userId)
                .userPw(this.userPw)
                .nickName(this.nickName)
                .email(this.email)
                .profileImg(this.profileImg)
                .build();
        return user;
    }
}
