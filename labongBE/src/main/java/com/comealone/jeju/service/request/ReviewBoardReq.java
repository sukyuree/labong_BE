package com.comealone.jeju.service.request;

import com.comealone.jeju.domain.model.MateBoard;
import com.comealone.jeju.domain.model.ReviewBoard;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
public class ReviewBoardReq {
    @NotNull
    String title;
    @NotNull
    String content;
    @NotNull
    Long attraction;

    String img;

    public ReviewBoard toReviewBoardModel(Long user){
        ReviewBoard reviewBoard = ReviewBoard.builder()
                .title(this.title)
                .content(this.content)
                .attraction(this.attraction)
                .img(this.img)
                .user(user)
                .build();
        return reviewBoard;
    }

    public ReviewBoard toReviewBoardModelForUpdate(Long id){
        ReviewBoard reviewBoard = ReviewBoard.builder()
                .id(id)
                .title(this.title)
                .content(this.content)
                .attraction(this.attraction)
                .img(this.img)
                .build();
        return reviewBoard;
    }
}
