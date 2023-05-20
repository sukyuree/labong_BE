package com.comealone.jeju.service.request;

import com.comealone.jeju.domain.model.MateBoard;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
public class MateBoardReq {
    @NotNull
    String title;
    @NotNull
    String content;
    @NotNull
    Date date;
    @NotNull
    String place;

    public MateBoard toMateBoardModel(Long user){
        MateBoard mateBoard = MateBoard.builder()
                .title(this.title)
                .content(this.content)
                .date(this.date)
                .place(this.place)
                .user(user)
                .build();
        return mateBoard;
    }
}
