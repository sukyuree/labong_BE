package com.comealone.jeju.service.request;

import com.comealone.jeju.domain.model.Follow;
import com.comealone.jeju.domain.model.Plan;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
public class PlanReq {
    @NotNull
    String planName;

    @NotNull
    Date startDate;

    @NotNull
    Date endDate;

    @NotNull
    String concept;

    public Plan toPlanModel(Long user){
        Plan plan = Plan.builder()
                .planName(this.planName)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .concept(this.concept)
                .user(user)
                .build();
        return plan;
    }
}
