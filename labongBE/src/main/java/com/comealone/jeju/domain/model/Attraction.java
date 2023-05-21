package com.comealone.jeju.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attraction {
    Long id;

    String title;

    String info;

    String address;

    String zipcode;

    BigDecimal latitude;

    BigDecimal longitude;

    String image1;

    String image2;

    String contentType;
}
