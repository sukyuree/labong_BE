package com.comealone.jeju.service.service;

import com.comealone.jeju.domain.model.Attraction;
import com.comealone.jeju.domain.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionRepository attractionRepository;

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
}
