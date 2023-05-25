package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.PlanDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlanRes extends BaseResponse{
    Long planId;
    public PlanRes(String msg, Integer status, Long planId){
        super(msg, status);
        this.planId = planId;
    }
}
