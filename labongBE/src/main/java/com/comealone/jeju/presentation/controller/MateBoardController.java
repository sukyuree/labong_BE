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
    public ResponseEntity<? extends BaseResponse> addPosts(@RequestBody MateBoardReq mateBoardReq){
        mateBoardService.addMateBoard(mateBoardReq);
        return ResponseEntity.status(201).body(new BaseResponse("글 등록에 성공했습니다.",201));
    }
}
