package com.comealone.jeju.service.service;

import com.comealone.jeju.domain.model.DetailPlan;
import com.comealone.jeju.domain.model.Plan;
import com.comealone.jeju.domain.model.User;
import com.comealone.jeju.domain.repository.DetailPlanRepository;
import com.comealone.jeju.domain.repository.PlanRepository;
import com.comealone.jeju.domain.repository.UserRepository;
import com.comealone.jeju.service.dto.DetailPlanDto;
import com.comealone.jeju.service.dto.PlanDto;
import com.comealone.jeju.service.request.DetailPlanReq;
import com.comealone.jeju.service.request.PlanReq;
import com.comealone.jeju.util.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;
    private final UserRepository userRepository;
    private final DetailPlanRepository detailPlanRepository;

    private User currentUser(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return user;
    }

    public boolean isWriter(Long planId){
        Plan plan = planRepository.findById(planId).orElse(null);
        User user = currentUser();

        return plan.getUser()==user.getId() ? true : false;
    }

    public boolean isPlanWriter(Long detailPlanId){
        DetailPlan detailPlan = detailPlanRepository.findById(detailPlanId).orElse(null);
        return isWriter(detailPlan.getPlan());
    }
    public List<PlanDto> getList(){
        return planRepository.findAll();
    }

    public List<PlanDto> getListByKeyword(String keywordType, String keyword){
        if(keywordType.equals("concept"))
            return planRepository.findAllByConcept(keyword);
        if(keywordType.equals("name"))
            return planRepository.findAllByPlanName(keyword);
        if(keywordType.equals("user"))
            return planRepository.findAllByUser(Long.parseLong(keyword));
        return null;
    }

    public Long addPlan(PlanReq planReq){
        User user = currentUser();
        Plan plan = planReq.toPlanModel(user.getId());
        planRepository.save(plan);
        return plan.getId();
    }

    public void modifyPlan(Long id, PlanReq planReq){
        Plan plan = planRepository.findById(id).orElse(null);
        Plan modifiedPlan = planReq.toPlanModel(plan.getUser());
        modifiedPlan.setId(plan.getId());
        planRepository.update(modifiedPlan);
    }

    public void deletePlan(Long id){
        planRepository.delete(id);
    }

    public void addDetailPlan(Long planId, DetailPlanReq detailPlanReq){
        detailPlanRepository.save(detailPlanReq.toDetailPlanModel(planId));
    }

    public void modifyDetailPlan(Long detailPlanId, DetailPlanReq detailPlanReq){
        DetailPlan detailPlan = detailPlanRepository.findById(detailPlanId).orElse(null);
        DetailPlan modifiedDetailPlan = detailPlanReq.toDetailPlanModel(detailPlan.getPlan());
        modifiedDetailPlan.setId(detailPlan.getId());
        detailPlanRepository.update(modifiedDetailPlan);
    }

    public void deleteDetailPlan(Long detailPlanId){
        detailPlanRepository.delete(detailPlanId);
    }

    public List<DetailPlanDto> getDetailPlans(Long planId){
        return detailPlanRepository.findAllByPlanId(planId);
    }
}
