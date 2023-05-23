package com.comealone.jeju.domain.model;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewBoard {
    Long id;
    String title;
    String img;
    String content;
    Long user;
    Long attraction;
    LocalDateTime createdAt;
}
