package com.comealone.jeju.domain.repository;

import com.comealone.jeju.domain.model.DetailPlan;
import com.comealone.jeju.service.dto.DetailPlanDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DetailPlanRepository {
    Optional<DetailPlan> findById(Long id);
    List<DetailPlanDto> findAllByPlanId(Long planId);
    void save(DetailPlan detailPlan);
    void update(DetailPlan detailPlan);
    void delete(Long id);
}
