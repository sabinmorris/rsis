package com.example.resis.controller;

import com.example.resis.dto.InsertDocumentTypeDto;
import com.example.resis.dto.InsertDonorTypeDto;
import com.example.resis.model.DonorType;
import com.example.resis.service.DonorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/donorType")
public class DonorTypeController {

    @Autowired
    private DonorTypeService donorTypeService;

    @PostMapping
    public DonorType insertDonorTypeInfo(@RequestBody InsertDonorTypeDto req){

        return donorTypeService.insertDonorTypeInfo(req);

    }

    @GetMapping
    public List<DonorType> selectDonorTypeInfo(){
        return donorTypeService.selectDonorTypeInfo();
    }

    @GetMapping("/{id}")
    public Optional<DonorType> selectDonorTypeInfoById(@PathVariable Long id){
        return donorTypeService.selectDonorTypeInfoById(id);
    }

    @PutMapping("/{id}")
    public DonorType updateDonorTypeInfo(@RequestBody InsertDonorTypeDto req, @PathVariable Long id){
        return donorTypeService.updateDonorTypeInfo(req, id);
    }
}
