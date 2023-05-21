package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.MateBoardDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateBoardRes extends BaseResponse{
    MateBoardDto mateBoardDto;
    public MateBoardRes(String msg, Integer status, MateBoardDto mateBoardDto){
        super(msg, status);
        this.mateBoardDto = mateBoardDto;
    }
}
