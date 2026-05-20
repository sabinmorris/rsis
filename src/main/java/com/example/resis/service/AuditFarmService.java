package com.example.resis.service;

import com.example.resis.dto.AuditFarmDto;
import com.example.resis.model.AuditFarm;
import com.example.resis.repository.AuditFarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AuditFarmService {
    @Autowired
    private AuditFarmRepository auditFarmRepository;

    public AuditFarm insertAuditFarmInfo(AuditFarmDto req){
        AuditFarm auditFarm = new AuditFarm();
        auditFarm.setAuditFarmName(req.getAuditFarmName());
        auditFarm.setCreatedAt(LocalDateTime.now());
        auditFarm.setCreatedBy(1L);
        return auditFarmRepository.save(auditFarm);
    }

    public List<AuditFarm> selectAuditFarmInfo(){
        return auditFarmRepository.findAll();
    }

    public Optional<AuditFarm> selectAudiFarmById(Long id){
        return auditFarmRepository.findById(id);
    }

    public AuditFarm updateAuditFarmInfo(AuditFarmDto req, Long id){
        Optional<AuditFarm> auditFarm = auditFarmRepository.findById(id);
        if (auditFarm.isPresent()){
            AuditFarm auditFarm1 = auditFarm.get();
            auditFarm1.setAuditFarmName(req.getAuditFarmName());
            auditFarm1.setUpdatedAt(LocalDateTime.now());
            auditFarm1.setUpdatedBy(2L);
            return auditFarmRepository.save(auditFarm1);
        }else {
            return null;
        }
    }
}
