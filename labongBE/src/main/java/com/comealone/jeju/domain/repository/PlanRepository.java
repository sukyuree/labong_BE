package com.comealone.jeju.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.comealone.jeju.domain.model.Plan;

@Mapper
public interface PlanRepository {
    List<Plan> findAll();
    List<Plan> findAllByConcept(String concept);
    List<Plan> findAllByUser(Long user);
}
