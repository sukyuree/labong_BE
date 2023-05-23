package com.comealone.jeju.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewLike {
    Long id;
    Long user;
    Long review;
}
