package com.comealone.jeju.service.response;

import com.comealone.jeju.domain.model.Attraction;
import com.comealone.jeju.service.dto.MateBoardDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AttractionListRes extends BaseResponse{
    List<Attraction> attractionList;
    public AttractionListRes(String msg, Integer status, List<Attraction> attractionList){
        super(msg, status);
        this.attractionList = attractionList;
    }
}
