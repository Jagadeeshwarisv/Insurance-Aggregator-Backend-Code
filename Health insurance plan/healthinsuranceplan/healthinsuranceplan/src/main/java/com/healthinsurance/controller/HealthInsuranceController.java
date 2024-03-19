package com.healthinsurance.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.healthinsurance.entity.HealthInsurancePlan;
import com.healthinsurance.service.HealthInsurancePlanService;
import com.healthinsurance.service.NotFoundException; // Add this import
 
@RestController
@RequestMapping("/health-insurance/plans")
public class HealthInsuranceController {
	@Autowired
    private final HealthInsurancePlanService healthInsurancePlanService;
 
    
    public HealthInsuranceController(HealthInsurancePlanService healthInsurancePlanService) {
        this.healthInsurancePlanService = healthInsurancePlanService;
    }
 
    @GetMapping
    public List<HealthInsurancePlan> getAllPlans() {
        return healthInsurancePlanService.getAllPlans();
    }
 
    @PostMapping
    public HealthInsurancePlan createPlan(@RequestBody HealthInsurancePlan plan) {
        return healthInsurancePlanService.createPlan(plan);
    }
 
    @GetMapping("/{id}")
    public HealthInsurancePlan getPlanById(@PathVariable Long id) {
        return healthInsurancePlanService.getPlanById(id);
    }
 
    @PutMapping("/{id}")
    public HealthInsurancePlan updatePlan(@PathVariable Long id, @RequestBody HealthInsurancePlan planDetails) {
        return healthInsurancePlanService.updatePlan(id, planDetails);
    }
 
    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
        healthInsurancePlanService.deletePlan(id);
    }
}
