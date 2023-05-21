package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.Attraction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AttractionRepository {
    Optional<Attraction> findById(Long id);
    List<Attraction> findAllByKeyword(String keyword);
    List<Attraction> findAllByAddress(String address);
}
