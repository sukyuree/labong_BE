package com.comealone.jeju.service.request;


import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class LoginReq {
    @NotNull
    String userId;

    @NotNull
    String userPw;
}
