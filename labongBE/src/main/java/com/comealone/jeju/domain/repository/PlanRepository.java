package com.comealone.jeju.domain.repository;

import java.util.List;
import java.util.Optional;

import com.comealone.jeju.service.dto.PlanDto;
import org.apache.ibatis.annotations.Mapper;

import com.comealone.jeju.domain.model.Plan;

@Mapper
public interface PlanRepository {
    Optional<Plan> findById(Long id);
    List<PlanDto> findAll();
    List<PlanDto> findAllByConcept(String concept);
    List<PlanDto> findAllByUser(Long user);
    List<PlanDto> findAllByPlanName(String keyword);
    void save(Plan plan);
    void update(Plan plan);
    void delete(Long id);
}
