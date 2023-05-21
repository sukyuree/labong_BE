package com.comealone.jeju.service.service;

import com.comealone.jeju.domain.model.MateBoard;
import com.comealone.jeju.domain.model.User;
import com.comealone.jeju.domain.repository.MateBoardRepository;
import com.comealone.jeju.domain.repository.UserRepository;
import com.comealone.jeju.service.request.MateBoardReq;
import com.comealone.jeju.util.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MateBoardService {
    private final MateBoardRepository mateBoardRepository;
    private final UserRepository userRepository;

    private User currentUser(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return user;
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

    public boolean isWriter(Long id){
        User user = currentUser();
        return user.getId()==id? true:false;
    }
}
