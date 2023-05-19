package com.comealone.jeju.service.response;

public class LoginRes extends BaseResponse{
	String accessToken;
	String refreshToken;

    public LoginRes(String msg, Integer status, String accessToken, String refreshToken){
        super(msg, status);
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
