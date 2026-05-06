package com.example.resis.controller;

import com.example.resis.dto.InsertAdministrativeCostDto;
import com.example.resis.model.AdministrativeCost;
import com.example.resis.service.AdministrativeCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/administrativeCostInfo")
public class AdministrativeCostController {

    @Autowired
    private AdministrativeCostService administrativeCostService;

    @PostMapping
    public AdministrativeCost insertAdministrativeCostInfo(@RequestBody InsertAdministrativeCostDto req){
        return administrativeCostService.insertAdministrativeCostInfo(req);
    }

    @GetMapping
    public List<AdministrativeCost> selectAdministrativeCostInfo(){
        return administrativeCostService.selectAdministrativeCostInfo();
    }

    @GetMapping("/{id}")
    public Optional<AdministrativeCost> selectAdministrativeCostById(@PathVariable Long id){
        return administrativeCostService.selectAdministrativeCostById(id);
    }

    @PutMapping("/{id}")
    public AdministrativeCost updateAdministrativeCostInfo(@RequestBody InsertAdministrativeCostDto req, @PathVariable Long id){
        return administrativeCostService.updateAdministrativeCostInfo(req,id);
    }
}
