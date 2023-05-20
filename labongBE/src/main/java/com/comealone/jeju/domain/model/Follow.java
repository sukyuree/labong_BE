package com.comealone.jeju.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Follow {
    Long Id;
    Long follower;
    Long following;
}
