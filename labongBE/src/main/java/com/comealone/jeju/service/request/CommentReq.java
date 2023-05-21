package com.comealone.jeju.service.request;

import com.comealone.jeju.domain.model.Comment;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CommentReq {
    @NotNull
    String content;

    public Comment toCommentModel(Long boardId, Long userId){
        Comment comment = Comment.builder()
                .user(userId)
                .board(boardId)
                .content(this.content)
                .build();
        return comment;
    }
}
