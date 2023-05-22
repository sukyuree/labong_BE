package com.comealone.jeju.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailPlanDto {
    Long detailPlanId;

    int day;

    int order;

    Long attId;

    String attTitle;

    String attAddress;

    BigDecimal attLatitude;

    BigDecimal attLongitude;

    String attImage1;

    String attImage2;
}
