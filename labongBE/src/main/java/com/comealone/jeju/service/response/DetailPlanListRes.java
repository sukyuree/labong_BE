package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.DetailPlanDto;
import com.comealone.jeju.service.dto.PlanDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetailPlanListRes extends BaseResponse{
    List<DetailPlanDto> detailPlanDtoList;

    public DetailPlanListRes(String msg, Integer status, List<DetailPlanDto> detailPlanDtoList){
        super(msg,status);
        this.detailPlanDtoList=detailPlanDtoList;
    }
}
