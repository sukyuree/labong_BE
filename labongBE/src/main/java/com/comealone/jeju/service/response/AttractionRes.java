package com.comealone.jeju.service.response;

import com.comealone.jeju.domain.model.Attraction;
import com.comealone.jeju.service.dto.AttractionDto;
import com.comealone.jeju.service.dto.MateBoardDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionRes extends BaseResponse{
    AttractionDto attractionDto;
    public AttractionRes(String msg, Integer status, AttractionDto attractionDto){
        super(msg, status);
        this.attractionDto = attractionDto;
    }
}
