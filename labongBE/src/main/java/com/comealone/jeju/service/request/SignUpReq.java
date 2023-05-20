package com.comealone.jeju.service.request;

import com.comealone.jeju.domain.model.User;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SignUpReq {
	@NotNull
	String userId;
	@NotNull
	String userPw;
	@NotNull
	String nickName;
	@NotNull
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
