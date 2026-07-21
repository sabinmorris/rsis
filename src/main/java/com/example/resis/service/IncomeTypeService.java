package com.example.resis.service;

import com.example.resis.dto.InsertIncomeTypeDto;
import com.example.resis.model.IncomeType;
import com.example.resis.repository.IncomeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeTypeService {
    @Autowired
    private IncomeTypeRepository incomeTypeRepository;

    public IncomeType insertIncomeType(InsertIncomeTypeDto req){

        IncomeType incomeType = new IncomeType();
        incomeType.setIncomeName(req.getIncomeName());
        incomeType.setCreatedAt(LocalDateTime.now());
        incomeType.setCreatedBy(1L);
        return incomeTypeRepository.save(incomeType);
    }

    public List<IncomeType> selectIncomeType(){
        return incomeTypeRepository.findAll();
    }

    public Optional<IncomeType> selectIncomeTypeById(Long id){
        return incomeTypeRepository.findById(id);
    }

    public IncomeType UpdateIncomeTypeInfo(InsertIncomeTypeDto req, Long id){

        Optional<IncomeType> incomeType = incomeTypeRepository.findById(id);

        if (incomeType.isPresent()){

            IncomeType incomeType1 = incomeType.get();
            incomeType1.setIncomeName(req.getIncomeName());
            incomeType1.setUpdatedBy(2L);
            incomeType1.setUpdatedAt(LocalDateTime.now());
            return incomeTypeRepository.save(incomeType1);
        }else {
            return null;
        }
    }
}
