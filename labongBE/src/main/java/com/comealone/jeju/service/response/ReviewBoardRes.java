package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.MateBoardDto;
import com.comealone.jeju.service.dto.ReviewBoardDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewBoardRes extends BaseResponse{
    ReviewBoardDto reviewBoardDto;
    public ReviewBoardRes(String msg, Integer status, ReviewBoardDto reviewBoardDto){
        super(msg, status);
        this.reviewBoardDto = reviewBoardDto;
    }
}
