package com.example.resis.controller;

import com.example.resis.dto.InsertEmployeeCategoryTypeDto;
import com.example.resis.model.EmployeeCategoryType;
import com.example.resis.service.EmployeeCategoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employeeCategoryType")
public class EmployeeCategoryTypeController {

    @Autowired
    private EmployeeCategoryTypeService employeeCategoryTypeService;

    @PostMapping
    public EmployeeCategoryType insertEmployeeCategoryInfo(@RequestBody InsertEmployeeCategoryTypeDto req){
        return  employeeCategoryTypeService.insertEmployeeCategoryInfo(req);
    }

    @GetMapping
    public List<EmployeeCategoryType> selectEmployeeCategoryTypeInfo(){

        return employeeCategoryTypeService.selectEmployeeCategoryTypeInfo();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeCategoryType> selectEmployeeCategoryTypeById(@PathVariable Long id){
        return employeeCategoryTypeService.selectEmployeeCategoryTypeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeCategoryType updateEmployeeCategoryInfo(@RequestBody InsertEmployeeCategoryTypeDto req, @PathVariable Long id){
        return employeeCategoryTypeService.updateEmployeeCategoryInfo(req, id);
    }
}
