package com.comealone.jeju.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetailPlan {
    Long id;
    int day;
    int order;
    Long plan;
    Long attraction;
}
