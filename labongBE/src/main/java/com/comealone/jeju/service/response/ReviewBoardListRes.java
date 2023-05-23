package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.MateBoardDto;
import com.comealone.jeju.service.dto.ReviewBoardDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReviewBoardListRes extends BaseResponse{
    List<ReviewBoardDto> reviewBoardDtoList;
    public ReviewBoardListRes(String msg, Integer status, List<ReviewBoardDto> reviewBoardDtoList){
        super(msg, status);
        this.reviewBoardDtoList = reviewBoardDtoList;
    }
}
