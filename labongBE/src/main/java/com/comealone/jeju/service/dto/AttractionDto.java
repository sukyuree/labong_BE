package com.comealone.jeju.service.dto;

import com.comealone.jeju.domain.model.Attraction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttractionDto {
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

    String gugunCode;

    int review;

    int like;

    public AttractionDto(Attraction attraction, int like){
        this.id = attraction.getId();
        this.title = attraction.getTitle();
        this.info = attraction.getInfo();
        this.address = attraction.getAddress();
        this.zipcode = attraction.getZipcode();
        this.latitude = attraction.getLatitude();
        this.longitude = attraction.getLongitude();
        this.image1 = attraction.getImage1();
        this.image2 = attraction.getImage2();
        this.like = like;
    }
}
