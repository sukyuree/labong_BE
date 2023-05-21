package com.comealone.jeju.service.dto;

import com.comealone.jeju.domain.model.Comment;
import com.comealone.jeju.domain.model.MateBoard;
import com.comealone.jeju.domain.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MateBoardDto {
    Long id;
    String title;
    String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date date;
    String place;
    String nickName;
    LocalDateTime createdAt;
    List<Comment> commentList;

    public MateBoardDto(MateBoard mateBoard, User user, List<Comment> commentList){
        this.id = mateBoard.getId();
        this.title = mateBoard.getTitle();
        this.content = mateBoard.getContent();
        this.date = mateBoard.getDate();
        this.place = mateBoard.getPlace();
        this.createdAt = mateBoard.getCreatedAt();
        this.nickName = user.getNickName();
        this.commentList = commentList;
    }
}
