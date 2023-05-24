package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRes extends BaseResponse{
	String accessToken;
	String refreshToken;
    UserDto userDto;
    public LoginRes(String msg, Integer status, String accessToken, String refreshToken, UserDto userDto){
        super(msg, status);
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userDto = userDto;
    }
}
