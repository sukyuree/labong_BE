package com.comealone.jeju.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

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
    
    Date EndDate;
    
    Long user;
    
    boolean isPriavte;
    
    String concept;
}
