package com.example.resis.service;

import com.example.resis.dto.InsertBeneficiariesCategoryDto;
import com.example.resis.model.BeneficiariesCategory;
import com.example.resis.repository.BeneficiariesCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiariesCategoryService {

    @Autowired
    private BeneficiariesCategoryRepository beneficiariesCategoryRepository;

    public BeneficiariesCategory insertBeneficiariesCategoryInfo(InsertBeneficiariesCategoryDto req){

        BeneficiariesCategory beneficiariesCategory = new BeneficiariesCategory();
        beneficiariesCategory.setBeneficiariesName(req.getBeneficiariesName());
        beneficiariesCategory.setCreatedAt(LocalDateTime.now());
        beneficiariesCategory.setCreatedBy(1L);
        return beneficiariesCategoryRepository.save(beneficiariesCategory);
    }

    public List<BeneficiariesCategory> selectBeneficiariesCategoryInfo(){
        return beneficiariesCategoryRepository.findAll();
    }

    public Optional<BeneficiariesCategory> selectBeneficiariesCategoryInfoById(Long id){

        return beneficiariesCategoryRepository.findById(id);
    }

    public BeneficiariesCategory updateBeneficiariesCategoryInfo(InsertBeneficiariesCategoryDto req, Long id){

        Optional<BeneficiariesCategory> beneficiariesCategory = beneficiariesCategoryRepository.findById(id);

        if(beneficiariesCategory.isPresent()){
            BeneficiariesCategory beneficiariesCategory1 = beneficiariesCategory.get();
            beneficiariesCategory1.setBeneficiariesName(req.getBeneficiariesName());
            beneficiariesCategory1.setUpdatedAt(LocalDateTime.now());
            beneficiariesCategory1.setUpdatedBy(2L);
            return beneficiariesCategoryRepository.save(beneficiariesCategory1);

        }else {
            return null;
        }
    }
}
