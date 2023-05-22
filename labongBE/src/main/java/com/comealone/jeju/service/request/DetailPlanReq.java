package com.comealone.jeju.service.request;

import com.comealone.jeju.domain.model.DetailPlan;
import com.comealone.jeju.domain.model.Plan;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
public class DetailPlanReq {
    int day;

    int order;

    Long attraction;

    public DetailPlan toDetailPlanModel(Long plan){
        DetailPlan detailplan = DetailPlan.builder()
                .day(this.day)
                .order(this.order)
                .attraction(this.attraction)
                .plan(plan)
                .build();
        return detailplan;
    }
}
