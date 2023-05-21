package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.MateBoardDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MateBoardListRes extends BaseResponse{
    List<MateBoardDto> mateBoardDtoList;
    public MateBoardListRes(String msg, Integer status, List<MateBoardDto> mateBoardDtoList){
        super(msg, status);
        this.mateBoardDtoList = mateBoardDtoList;
    }
}
