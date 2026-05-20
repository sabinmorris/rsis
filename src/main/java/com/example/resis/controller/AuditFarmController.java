package com.example.resis.controller;

import com.example.resis.dto.AuditFarmDto;
import com.example.resis.model.AuditFarm;
import com.example.resis.service.AuditFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auditfarm")
public class AuditFarmController {
    @Autowired
    private AuditFarmService auditFarmService;

    @PostMapping
    public AuditFarm insertAuditFarmInfo(@RequestBody AuditFarmDto req){
        return auditFarmService.insertAuditFarmInfo(req);
    }

    @GetMapping
    public List<AuditFarm> selectAuditFarmInfo(){
        return auditFarmService.selectAuditFarmInfo();
    }

    @GetMapping("/{id}")
    public Optional<AuditFarm> selectAudiFarmById(@PathVariable Long id){

        return auditFarmService.selectAudiFarmById(id);
    }

    @PutMapping("/{id}")
    public AuditFarm updateAuditFarmInfo(@RequestBody AuditFarmDto req, @PathVariable Long id){

        return auditFarmService.updateAuditFarmInfo(req, id);
    }
}
