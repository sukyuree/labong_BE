package com.comealone.jeju.service.service;

import com.comealone.jeju.domain.model.*;
import com.comealone.jeju.domain.repository.*;
import com.comealone.jeju.service.dto.CommentDto;
import com.comealone.jeju.service.dto.MateBoardDto;
import com.comealone.jeju.service.dto.ReviewBoardDto;
import com.comealone.jeju.service.request.CommentReq;
import com.comealone.jeju.service.request.MateBoardReq;
import com.comealone.jeju.service.request.ReviewBoardReq;
import com.comealone.jeju.util.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewBoardService {
    private final ReviewBoardRepository reviewBoardRepository;
    private final UserRepository userRepository;
    private final ReviewLikeRepository reviewLikeRepository;

    private User currentUser(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return user;
    }

    public List<ReviewBoardDto> getAllReviewBoard(){
        List<ReviewBoardDto> reviewBoardDtoList = reviewBoardRepository.findAll();
        return reviewBoardDtoList;
    }

    public ReviewBoardDto getReviewBoard(Long id){
        ReviewBoardDto reviewBoardDto = reviewBoardRepository.findById(id).orElse(null);
        return reviewBoardDto;
    }

    @Transactional
    public void addReviewBoard(ReviewBoardReq reviewBoardReq){
        User user = currentUser();
        reviewBoardRepository.save(reviewBoardReq.toReviewBoardModel(user.getId()));
    }

    @Transactional
    public void modifyReviewBoard(Long id,ReviewBoardReq reviewBoardReq){
        reviewBoardRepository.update(reviewBoardReq.toReviewBoardModelForUpdate(id));
    }

    @Transactional
    public void deleteReviewBoard(Long id){
        reviewBoardRepository.delete(id);
    }

    public boolean isWriter(Long id){
        User user = currentUser();
        ReviewBoardDto reviewBoardDto = reviewBoardRepository.findById(id).orElse(null);
        return user.getNickName()==reviewBoardDto.getNickName() ? true:false;
    }

    @Transactional
    public boolean addOrSubLike(Long reviewId) {
        User user = currentUser();
        ReviewLike reviewLike = reviewLikeRepository.findByUserAndReview(user.getId(), reviewId).orElse(null);
        boolean rtn = true;
        if (reviewLike == null) {
            reviewLike = ReviewLike.builder()
                    .user(user.getId())
                    .review(reviewId)
                    .build();
            reviewLikeRepository.save(reviewLike);
        } else {
            reviewLikeRepository.delete(user.getId(), reviewId);
            rtn = false;
        }
        return rtn;
    }
}
