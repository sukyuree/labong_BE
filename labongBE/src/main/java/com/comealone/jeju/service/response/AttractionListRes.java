package com.comealone.jeju.service.response;

import com.comealone.jeju.domain.model.Attraction;
import com.comealone.jeju.service.dto.AttractionDto;
import com.comealone.jeju.service.dto.MateBoardDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AttractionListRes extends BaseResponse{
    List<AttractionDto> attractionDtoList;
    public AttractionListRes(String msg, Integer status, List<AttractionDto> attractionDtoList){
        super(msg, status);
        this.attractionDtoList = attractionDtoList;
    }
}
