package com.comealone.jeju.service.response;

import com.comealone.jeju.domain.model.Attraction;
import com.comealone.jeju.service.dto.MateBoardDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionRes extends BaseResponse{
    Attraction attraction;
    public AttractionRes(String msg, Integer status, Attraction attraction){
        super(msg, status);
        this.attraction = attraction;
    }
}
