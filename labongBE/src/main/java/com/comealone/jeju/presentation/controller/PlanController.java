package com.comealone.jeju.presentation.controller;

import com.comealone.jeju.service.request.DetailPlanReq;
import com.comealone.jeju.service.request.PlanReq;
import com.comealone.jeju.service.response.BaseResponse;
import com.comealone.jeju.service.response.DetailPlanListRes;
import com.comealone.jeju.service.response.PlanListRes;
import com.comealone.jeju.service.response.PlanRes;
import com.comealone.jeju.service.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @GetMapping
    public ResponseEntity<? extends BaseResponse> getPlanList(){
        return ResponseEntity.status(200).body(new PlanListRes("계획 목록 조회에 성공했습니다.",200,planService.getList()));
    }

    @GetMapping("/option")
    public ResponseEntity<? extends BaseResponse> getPlanList(@RequestParam String keywordType, String keyword){
        return ResponseEntity.status(200).body(new PlanListRes("계획 목록 조회에 성공했습니다.",200,planService.getListByKeyword(keywordType,keyword)));
    }

    @PostMapping
    public ResponseEntity<? extends BaseResponse> addPlan(@RequestBody PlanReq planReq){
        Long id = planService.addPlan(planReq);
        return ResponseEntity.status(201).body(new PlanRes("계획 등록에 성공했습니다.",201,id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> modifyPlan(@PathVariable Long id,@RequestBody PlanReq planReq){
        if(!planService.isWriter(id))
            return ResponseEntity.status(200).body(new BaseResponse("계획 수정 권한이 없습니다.",403));
        planService.modifyPlan(id,planReq);
        return ResponseEntity.status(200).body(new BaseResponse("계획 수정에 성공했습니다.",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends BaseResponse> deletePlan(@PathVariable Long id){
        if(!planService.isWriter(id))
            return ResponseEntity.status(200).body(new BaseResponse("계획 삭제 권한이 없습니다.",403));
        planService.deletePlan(id);
        return ResponseEntity.status(200).body(new BaseResponse("계획 삭제에 성공했습니다.",200));
    }

    @GetMapping("{id}/detail")
    public ResponseEntity<? extends BaseResponse> getDetailPlanList(@PathVariable Long id){
        return ResponseEntity.status(200).body(new DetailPlanListRes("계획 목록 조회에 성공했습니다.",200,planService.getDetailPlans(id)));
    }

    @PostMapping("{id}/detail")
    public ResponseEntity<? extends BaseResponse> addDetailPlan(@PathVariable Long id,@RequestBody DetailPlanReq detailPlanReq){
        planService.addDetailPlan(id,detailPlanReq);
        return ResponseEntity.status(201).body(new BaseResponse("세부 계획 등록에 성공했습니다.",201));
    }

    @PutMapping("/detail/{id}")
    public ResponseEntity<? extends BaseResponse> modifyDetailPlan(@PathVariable Long id,@RequestBody DetailPlanReq detailPlanReq){
        System.out.println("hi");
        if(!planService.isPlanWriter(id))
            return ResponseEntity.status(200).body(new BaseResponse("세부 계획 수정 권한이 없습니다.",403));
        planService.modifyDetailPlan(id, detailPlanReq);
        return ResponseEntity.status(201).body(new BaseResponse("세부 계획 수정에 성공했습니다.",201));
    }

    @DeleteMapping("/detail/{id}")
    public ResponseEntity<? extends BaseResponse> deleteDetailPlan(@PathVariable Long id){
        System.out.println("hi");
        if(!planService.isPlanWriter(id))
            return ResponseEntity.status(200).body(new BaseResponse("세부 계획 삭제 권한이 없습니다.",403));
        planService.deleteDetailPlan(id);
        return ResponseEntity.status(200).body(new BaseResponse("세부 계획 삭제에 성공했습니다.",200));
    }
    // Todo : 계획 삭제되면 세부계획 먼저 싹 삭제하는 방법 추가해야함.
}
