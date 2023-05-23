package com.comealone.jeju.service.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FileUploadRes extends BaseResponse{
	String filePath;

    public FileUploadRes(String msg, Integer status, String filePath){
        super(msg, status);
        this.filePath=filePath;
    }
}
