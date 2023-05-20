package com.comealone.jeju.presentation.controller;

import com.comealone.jeju.service.dto.TokenDto;
import com.comealone.jeju.service.request.*;
import com.comealone.jeju.service.response.*;
import com.comealone.jeju.service.service.CertificationService;
import com.comealone.jeju.service.service.MailService;
import com.comealone.jeju.service.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MailService mailService;
    private final CertificationService certificationService;
    
    @PostMapping("/signup")
    public ResponseEntity<? extends BaseResponse> addUser(@Valid @RequestBody SignUpReq signUpReq){
        if(userService.isExistUserId(signUpReq.getUserId()))
            return ResponseEntity.status(409).body(new BaseResponse("이미 존재하는 ID 입니다.", 409));
        if(userService.isExistEmail(signUpReq.getEmail()))
            return ResponseEntity.status(409).body(new BaseResponse("이미 존재하는 Email 입니다.", 409));
        if(userService.isExistNickName(signUpReq.getNickName()))
            return ResponseEntity.status(409).body(new BaseResponse("이미 존재하는 닉네임 입니다.", 409));

        signUpReq.setUserPw(userService.encryptPassword(signUpReq.getUserPw()));
        userService.save(signUpReq);
        return ResponseEntity.status(201).body(new BaseResponse("회원가입이 완료되었습니다.",201));
    }

    @PostMapping("/certification")
    public ResponseEntity<? extends BaseResponse> sendEmailCertifiaction(@RequestBody EmailCertificationReq emailCertificationReq)
            throws MessagingException {
    	System.out.println("HI");
        String randomCode = certificationService.makeCertificationCode(emailCertificationReq.getEmail());
        mailService.sendSignUpCertificationMail(emailCertificationReq.getEmail(), randomCode);
        return ResponseEntity.status(201).body(new BaseResponse("인증코드 발송을 완료했습니다.", 201));
    }

    @PostMapping("/verification")
    public ResponseEntity<? extends BaseResponse> verifyEmailCertification(@RequestBody EmailVerificationReq emailVerificationReq) {
        if(certificationService.verifyCertificationCode(emailVerificationReq.getEmail(),emailVerificationReq.getRandomCode()))
            return ResponseEntity.status(200).body(new BaseResponse("인증에 성공했습니다.", 200));
        return ResponseEntity.status(400).body(new BaseResponse("인증을 실패했습니다.", 400));
    }

    @PostMapping("/login")
    public ResponseEntity<? extends BaseResponse> loginUser(@Valid @RequestBody LoginReq loginReq) {
        if(!userService.isExistUserId(loginReq.getUserId()))
            return ResponseEntity.status(400).body(new BaseResponse("존재하지 않는 ID 입니다.", 400));

        if(!userService.matchPassword(loginReq.getUserId(),loginReq.getUserPw()))
            return ResponseEntity.status(400).body(new BaseResponse("패스워드가 틀렸습니다.", 400));

        TokenDto tokenDto = userService.createToken(loginReq);
        
        // Todo : 로그인 할 때 친구 목록 넘겨주기.
        return ResponseEntity.status(200).body(new LoginRes("로그인에 성공했습니다.",200, tokenDto.getAccessToken(),tokenDto.getRefreshToken()));
    }
}