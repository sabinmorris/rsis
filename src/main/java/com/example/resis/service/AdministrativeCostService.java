package com.example.resis.service;

import com.example.resis.dto.InsertAdministrativeCostDto;
import com.example.resis.model.AdministrativeCost;
import com.example.resis.repository.AdministrativeCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdministrativeCostService {

    @Autowired
    private AdministrativeCostRepository administrativeCostRepository;

    public AdministrativeCost insertAdministrativeCostInfo(InsertAdministrativeCostDto req){

        AdministrativeCost administrativeCost = new AdministrativeCost();
        administrativeCost.setCostName(req.getCostName());
        administrativeCost.setCreatedAt(LocalDateTime.now());
        administrativeCost.setCreatedBy(1L);
        return administrativeCostRepository.save(administrativeCost);
    }

    public List<AdministrativeCost> selectAdministrativeCostInfo(){
        return administrativeCostRepository.findAll();
    }

    public Optional<AdministrativeCost> selectAdministrativeCostById(Long id){
        return administrativeCostRepository.findById(id);
    }

    public AdministrativeCost updateAdministrativeCostInfo(@RequestBody InsertAdministrativeCostDto req, Long id){

        Optional<AdministrativeCost> administrativeCost = administrativeCostRepository.findById(id);

        if (administrativeCost.isPresent()){
            AdministrativeCost administrativeCost1 = administrativeCost.get();
            administrativeCost1.setCostName(req.getCostName());
            administrativeCost1.setUpdatedAt(LocalDateTime.now());
            administrativeCost1.setUpdatedBy(2L);
            return administrativeCostRepository.save(administrativeCost1);

        }else{
            return null;
        }
    }
}
