package com.example.resis.controller;

import com.example.resis.dto.InsertBeneficiariesCategoryDto;
import com.example.resis.model.BeneficiariesCategory;
import com.example.resis.service.BeneficiariesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/beneficiariesCategory")
public class BeneficiariesCategoryController {

    @Autowired
    private BeneficiariesCategoryService beneficiariesCategoryService;

    @PostMapping
    public BeneficiariesCategory insertBeneficiariesCategoryInfo(@RequestBody InsertBeneficiariesCategoryDto req){
        return beneficiariesCategoryService.insertBeneficiariesCategoryInfo(req);
    }

    @GetMapping()
    public List<BeneficiariesCategory> selectBeneficiariesCategoryInfo(){
        return beneficiariesCategoryService.selectBeneficiariesCategoryInfo();
    }

    @GetMapping("/{id}")
    public Optional<BeneficiariesCategory> selectBeneficiariesCategoryInfoById(Long id){
        return beneficiariesCategoryService.selectBeneficiariesCategoryInfoById(id);
    }

    @PutMapping("/{id}")
    public BeneficiariesCategory updateBeneficiariesCategoryInfo(@RequestBody InsertBeneficiariesCategoryDto req, Long id){
        return beneficiariesCategoryService.updateBeneficiariesCategoryInfo(req, id);
    }
}
