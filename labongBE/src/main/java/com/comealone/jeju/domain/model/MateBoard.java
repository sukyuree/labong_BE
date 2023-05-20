package com.comealone.jeju.domain.model;

import lombok.*;

import java.util.Date;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MateBoard {
    Long id;
    String title;
    String content;
    Date date;
    String place;
    Long user;
    LocalDateTime createdAt;
}
