package com.comealone.jeju.presentation.controller;

import com.comealone.jeju.service.response.BaseResponse;
import com.comealone.jeju.service.response.FileUploadRes;
import com.comealone.jeju.service.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = { "*" })
@RequiredArgsConstructor
public class FileUploadController {
    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<? extends BaseResponse> writeReview(@RequestParam("upfile") MultipartFile file, @RequestParam("dir") String dir) {
        String rtn = fileService.upload(file,dir);
        if(rtn == null)
            return ResponseEntity.status(204).body(new BaseResponse("파일 업로드 실패.",204));
        return ResponseEntity.status(200).body(new FileUploadRes("파일 업로드 성공.",200,rtn));
    }
}
