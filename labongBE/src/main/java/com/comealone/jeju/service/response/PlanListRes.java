package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.MateBoardDto;
import com.comealone.jeju.service.dto.PlanDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlanListRes extends BaseResponse{
    List<PlanDto> planDtoList;
    public PlanListRes(String msg, Integer status, List<PlanDto> planDtoList){
        super(msg, status);
        this.planDtoList = planDtoList;
    }
}
