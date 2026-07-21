package com.example.resis.controller;

import com.example.resis.dto.InsertIncomeTypeDto;
import com.example.resis.model.IncomeType;
import com.example.resis.service.IncomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/incomeSource")
public class IncomeTypeController {

    @Autowired
    private IncomeTypeService incomeTypeService;

    @PostMapping
    public IncomeType insertIncomeType(@RequestBody InsertIncomeTypeDto req){
        return incomeTypeService.insertIncomeType(req);
    }

    @GetMapping
    public List<IncomeType> selectIncomeType(){
        return incomeTypeService.selectIncomeType();
    }

    @GetMapping("/{id}")
    public Optional<IncomeType> selectIncomeTypeById(@PathVariable Long id){

        return incomeTypeService.selectIncomeTypeById(id);
    }

    @PutMapping("/{id}")
    public IncomeType updateIncomeTypeInfo(@RequestBody InsertIncomeTypeDto req, @PathVariable Long id){
        return incomeTypeService.UpdateIncomeTypeInfo(req, id);
    }
}
