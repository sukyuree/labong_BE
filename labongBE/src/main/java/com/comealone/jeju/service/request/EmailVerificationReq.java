package com.comealone.jeju.service.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class EmailVerificationReq {
    @NotNull
    String email;

    @NotNull
    String randomCode;
}
