package com.comealone.jeju.service.dto;

import com.comealone.jeju.domain.model.Attraction;
import com.comealone.jeju.domain.model.MateBoard;
import com.comealone.jeju.domain.model.ReviewBoard;
import com.comealone.jeju.domain.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewBoardDto {
    Long id;
    String title;
    String img;
    String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-hh:mm:ss")
    LocalDateTime createdAt;

    String nickName;

    String attraction;

    int like;
    public ReviewBoardDto(ReviewBoard reviewBoard, User user, Attraction attraction){
        this.id = reviewBoard.getId();
        this.title = reviewBoard.getTitle();
        this.content = reviewBoard.getContent();
        this.createdAt = reviewBoard.getCreatedAt();
        this.nickName = user.getNickName();
        this.attraction = attraction.getTitle();
    }
}
