package com.comealone.jeju.presentation.controller;

import com.comealone.jeju.service.response.AttractionListRes;
import com.comealone.jeju.service.response.AttractionRes;
import com.comealone.jeju.service.response.BaseResponse;
import com.comealone.jeju.service.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/attraction")
@RequiredArgsConstructor
public class AttractionController {
    private final AttractionService attractionService;

    @GetMapping("/option")
    public ResponseEntity<? extends BaseResponse> searchByKeyword(@RequestParam String keywordType, String keyword){
        return ResponseEntity.status(200).body(new AttractionListRes("조회에 성공했습니다.",200,attractionService.searchByKeyword(keywordType,keyword)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> getAttraction(@PathVariable Long id){
        return ResponseEntity.status(200).body(new AttractionRes("조회에 성공했습니다.",200,attractionService.getAttraction(id)));
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<? extends BaseResponse> addLike(@PathVariable Long id){
        boolean addOrSub = attractionService.addOrSubLike(id);
        if(addOrSub)
            return ResponseEntity.status(201).body(new BaseResponse("좋아요가 완료되었습니다.",201));
        return ResponseEntity.status(200).body(new BaseResponse("좋아요가 취소되었습니다.",200));
    }
}
