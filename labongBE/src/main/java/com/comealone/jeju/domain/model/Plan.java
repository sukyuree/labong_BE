package com.comealone.jeju.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Plan {
    Long id;

    String planName;

    Date startDate;
    
    Date endDate;
    
    Long user;
    
    String concept;

    LocalDateTime createdAt;
}
