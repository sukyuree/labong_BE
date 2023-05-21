package com.comealone.jeju.service.service;

import com.comealone.jeju.domain.model.Comment;
import com.comealone.jeju.domain.model.MateBoard;
import com.comealone.jeju.domain.model.User;
import com.comealone.jeju.domain.repository.CommentRepository;
import com.comealone.jeju.domain.repository.MateBoardRepository;
import com.comealone.jeju.domain.repository.UserRepository;
import com.comealone.jeju.service.dto.CommentDto;
import com.comealone.jeju.service.dto.MateBoardDto;
import com.comealone.jeju.service.request.CommentReq;
import com.comealone.jeju.service.request.MateBoardReq;
import com.comealone.jeju.util.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MateBoardService {
    private final MateBoardRepository mateBoardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    private User currentUser(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return user;
    }

    public List<MateBoardDto> getAllMateBoard(){
        List<MateBoardDto> mateBoardDtoList = new ArrayList<>();
        List<MateBoard> mateBoardList = mateBoardRepository.findAll();
        for(MateBoard m : mateBoardList){
            User user = userRepository.findById(m.getUser()).orElse(null);
            List<CommentDto> commentList = commentRepository.findAllByBoardId(m.getId());
            mateBoardDtoList.add(new MateBoardDto(m,user,commentList));
        }
        return mateBoardDtoList;
    }

    public MateBoardDto getMateBoard(Long id){
        MateBoard mateBoard = mateBoardRepository.findById(id).orElse(null);
        Date date = mateBoard.getDate();
        System.out.println(date);
        User user = userRepository.findById(mateBoard.getUser()).orElse(null);
        List<CommentDto> commentList = commentRepository.findAllByBoardId(id);
        return new MateBoardDto(mateBoard,user,commentList);
    }

    @Transactional
    public void addMateBoard(MateBoardReq mateBoardReq){
        User user = currentUser();
        mateBoardRepository.save(mateBoardReq.toMateBoardModel(user.getId()));
    }

    @Transactional
    public void modifyMateBoard(Long id,MateBoardReq mateBoardReq){
        mateBoardRepository.update(mateBoardReq.toMateBoardModelForUpdate(id));
    }

    @Transactional
    public void deleteMateBoard(Long id){
        mateBoardRepository.delete(id);
    }
    public boolean isWriter(Long id){
        User user = currentUser();
        MateBoard mateBoard = mateBoardRepository.findById(id).orElse(null);
        return user.getId()==mateBoard.getUser() ? true:false;
    }

    @Transactional
    public void addComment(Long id, CommentReq commentReq){
        User user = currentUser();
        Comment comment = commentReq.toCommentModel(id,user.getId());
        commentRepository.save(comment);
    }

    @Transactional
    public void modifyComment(Long commentId, CommentReq commentReq){
        Comment comment = commentRepository.findById(commentId).orElse(null);
        comment.setContent(commentReq.getContent());
        commentRepository.update(comment);
    }

    @Transactional
    public void deleteComment(Long commentId){
        commentRepository.delete(commentId);
    }

    public boolean isCommentWriter(Long commentId){
        User user = currentUser();
        Comment comment = commentRepository.findById(commentId).orElse(null);
        return user.getId()==comment.getUser() ? true:false;
    }
}
