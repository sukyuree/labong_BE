package com.comealone.jeju.service.response;

import com.comealone.jeju.service.dto.AttractionDto;
import com.comealone.jeju.service.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginRes extends BaseResponse{
	String accessToken;
	String refreshToken;
    UserDto userDto;
    List<AttractionDto> likedAttraction;
    public LoginRes(String msg, Integer status, String accessToken, String refreshToken, UserDto userDto, List<AttractionDto> likedAttractionDto){
        super(msg, status);
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userDto = userDto;
        this.likedAttraction = likedAttractionDto;
    }
}
