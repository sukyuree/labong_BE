package com.comealone.jeju.service.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DupCheckReq {
    String userId;

    String nickName;

    String email;
}
