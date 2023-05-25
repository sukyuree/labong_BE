package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.Attraction;
import com.comealone.jeju.service.dto.AttractionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AttractionRepository {
    Optional<AttractionDto> findById(Long id);
    List<AttractionDto> findAllByKeyword(String keyword);
    List<AttractionDto> findAllByAddress(String address);
    List<AttractionDto> findAll();
}
