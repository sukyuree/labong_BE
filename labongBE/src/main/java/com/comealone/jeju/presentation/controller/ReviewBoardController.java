package com.comealone.jeju.presentation.controller;

import com.comealone.jeju.service.dto.MateBoardDto;
import com.comealone.jeju.service.dto.ReviewBoardDto;
import com.comealone.jeju.service.request.CommentReq;
import com.comealone.jeju.service.request.MateBoardReq;
import com.comealone.jeju.service.request.ReviewBoardReq;
import com.comealone.jeju.service.response.*;
import com.comealone.jeju.service.service.MateBoardService;
import com.comealone.jeju.service.service.ReviewBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/review-board")
@RequiredArgsConstructor
public class ReviewBoardController {
    private final ReviewBoardService reviewBoardService;

    @PostMapping
    public ResponseEntity<? extends BaseResponse> addPost(@RequestBody ReviewBoardReq reviewBoardReq){
        reviewBoardService.addReviewBoard(reviewBoardReq);
        return ResponseEntity.status(201).body(new BaseResponse("글 등록에 성공했습니다.",201));
    }

    @GetMapping
    public ResponseEntity<? extends BaseResponse> getAllPost(){
        List<ReviewBoardDto> reviewBoardDtoList = reviewBoardService.getAllReviewBoard();
        return ResponseEntity.status(200).body(new ReviewBoardListRes("글 조회에 성공했습니다.",200, reviewBoardDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> getPost(@PathVariable Long id){
        ReviewBoardDto reviewBoardDto = reviewBoardService.getReviewBoard(id);
        return ResponseEntity.status(200).body(new ReviewBoardRes("글 조회에 성공했습니다.",200,reviewBoardDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> modifyPost(@PathVariable Long id, @RequestBody ReviewBoardReq reviewBoardReq){
        if(!reviewBoardService.isWriter(id))
            ResponseEntity.status(403).body(new BaseResponse("글 수정 권한이 없습니다.",403));
        reviewBoardService.modifyReviewBoard(id, reviewBoardReq);
        return ResponseEntity.status(201).body(new BaseResponse("글 수정에 성공했습니다.",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> deletePost(@PathVariable Long id){
        if(!reviewBoardService.isWriter(id))
            ResponseEntity.status(403).body(new BaseResponse("글 삭제 권한이 없습니다.",403));
        reviewBoardService.deleteReviewBoard(id);
        return ResponseEntity.status(200).body(new BaseResponse("글 삭제에 성공했습니다.",200));
    }
}
