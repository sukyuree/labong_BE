package com.comealone.jeju.domain.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    Long id;
    Long user;
    Long board;
    String content;
}
