package com.comealone.jeju.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttractionLike {
    Long id;
    Long user;
    Long attraction;
}
