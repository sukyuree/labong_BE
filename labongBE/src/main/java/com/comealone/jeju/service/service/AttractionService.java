package com.comealone.jeju.service.service;

import com.comealone.jeju.domain.model.Attraction;
import com.comealone.jeju.domain.model.AttractionLike;
import com.comealone.jeju.domain.model.User;
import com.comealone.jeju.domain.repository.AttractionLikeRepository;
import com.comealone.jeju.domain.repository.AttractionRepository;
import com.comealone.jeju.domain.repository.UserRepository;
import com.comealone.jeju.util.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionRepository attractionRepository;
    private final UserRepository userRepository;
    private final AttractionLikeRepository attractionLikeRepository;

    private User currentUser(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return user;
    }

    public Attraction getAttraction(Long id){
        return attractionRepository.findById(id).orElse(null);
    }

    public List<Attraction> searchByKeyword(String keywordType, String keyword){
        if(keywordType.equals("address"))
            return attractionRepository.findAllByAddress(keyword);
        if(keywordType.equals("keyword"))
            return attractionRepository.findAllByKeyword(keyword);
        return null;
    }

    @Transactional
    public boolean addOrSubLike(Long attractionId){
        User user = currentUser();
        AttractionLike attractionLike = attractionLikeRepository.findByUserAndAttraction(user.getId(),attractionId).orElse(null);
        boolean rtn = true;
        if(attractionLike == null){
            attractionLike = AttractionLike.builder()
                    .user(user.getId())
                    .attraction(attractionId)
                    .build();
            attractionLikeRepository.save(attractionLike);
        }
        else{
            attractionLikeRepository.delete(user.getId(),attractionId);
            rtn = false;
        }
        return rtn;
    }
}
