package com.comealone.jeju.presentation.controller;

import com.comealone.jeju.service.request.MateBoardReq;
import com.comealone.jeju.service.response.BaseResponse;
import com.comealone.jeju.service.service.MateBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
