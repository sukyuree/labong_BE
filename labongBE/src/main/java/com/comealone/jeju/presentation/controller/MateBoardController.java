package com.comealone.jeju.presentation.controller;

import com.comealone.jeju.service.dto.MateBoardDto;
import com.comealone.jeju.service.request.CommentReq;
import com.comealone.jeju.service.request.MateBoardReq;
import com.comealone.jeju.service.response.BaseResponse;
import com.comealone.jeju.service.response.MateBoardListRes;
import com.comealone.jeju.service.response.MateBoardRes;
import com.comealone.jeju.service.service.MateBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/mate-board")
@RequiredArgsConstructor
public class MateBoardController {
    private final MateBoardService mateBoardService;

    @PostMapping
    public ResponseEntity<? extends BaseResponse> addPost(@RequestBody MateBoardReq mateBoardReq){
        mateBoardService.addMateBoard(mateBoardReq);
        return ResponseEntity.status(201).body(new BaseResponse("글 등록에 성공했습니다.",201));
    }

    @GetMapping
    public ResponseEntity<? extends BaseResponse> getAllPost(){
        List<MateBoardDto> mateBoardDtoList = mateBoardService.getAllMateBoard();
        return ResponseEntity.status(200).body(new MateBoardListRes("글 조회에 성공했습니다.",200, mateBoardDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> getPost(@PathVariable Long id){
        MateBoardDto mateBoardDto = mateBoardService.getMateBoard(id);
        return ResponseEntity.status(200).body(new MateBoardRes("글 조회에 성공했습니다.",200,mateBoardDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> modifyPost(@PathVariable Long id, @RequestBody MateBoardReq mateBoardReq){
        if(!mateBoardService.isWriter(id))
            ResponseEntity.status(403).body(new BaseResponse("글 수정 권한이 없습니다.",403));
        mateBoardService.modifyMateBoard(id, mateBoardReq);
        return ResponseEntity.status(201).body(new BaseResponse("글 수정에 성공했습니다.",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> deletePost(@PathVariable Long id){
        if(!mateBoardService.isWriter(id))
            ResponseEntity.status(403).body(new BaseResponse("글 수정 권한이 없습니다.",403));
        mateBoardService.deleteMateBoard(id);
        return ResponseEntity.status(200).body(new BaseResponse("글 삭제에 성공했습니다.",200));
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<? extends BaseResponse> addComment(@PathVariable Long id, @RequestBody CommentReq commentReq){
        mateBoardService.addComment(id,commentReq);
        return ResponseEntity.status(201).body(new BaseResponse("댓글이 등록되었습니다.",201));
    }
}
