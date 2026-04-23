package com.example.resis.service;

import com.example.resis.dto.InsertEmployeeCategoryTypeDto;
import com.example.resis.model.EmployeeCategoryType;
import com.example.resis.repository.EmployeeCategoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeCategoryTypeService {

    @Autowired
    private EmployeeCategoryTypeRepository employeeCategoryTypeRepository;

    public EmployeeCategoryType insertEmployeeCategoryInfo(InsertEmployeeCategoryTypeDto req){

        EmployeeCategoryType employeeCategoryType = new EmployeeCategoryType();
        employeeCategoryType.setEmployeeCategoryName(req.getEmployeeCategoryName());
        employeeCategoryType.setCreatedAt(LocalDateTime.now());
        employeeCategoryType.setCreatedBy(1L);
        return employeeCategoryTypeRepository.save(employeeCategoryType);
    }

    public List<EmployeeCategoryType> selectEmployeeCategoryTypeInfo(){

        return employeeCategoryTypeRepository.findAll();
    }

    public Optional<EmployeeCategoryType> selectEmployeeCategoryTypeById(Long id){

        return employeeCategoryTypeRepository.findById(id);
    }

    public EmployeeCategoryType updateEmployeeCategoryInfo(InsertEmployeeCategoryTypeDto req, Long id){

        Optional<EmployeeCategoryType> employeeCategoryType = employeeCategoryTypeRepository.findById(id);

        if (employeeCategoryType.isPresent()){
            EmployeeCategoryType employeeCategoryType1 = employeeCategoryType.get();
            employeeCategoryType1.setEmployeeCategoryName(req.getEmployeeCategoryName());
            employeeCategoryType1.setUpdatedAt(LocalDateTime.now());
            employeeCategoryType1.setUpdatedBy(2L);
            return employeeCategoryTypeRepository.save(employeeCategoryType1);
        }else{

            return null;
        }

    }
}
