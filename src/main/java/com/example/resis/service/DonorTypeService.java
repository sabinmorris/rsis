package com.example.resis.service;

import com.example.resis.dto.InsertDonorTypeDto;
import com.example.resis.model.DonorType;
import com.example.resis.repository.DonorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DonorTypeService {

    @Autowired
    private DonorTypeRepository donorTypeRepository;

    public DonorType insertDonorTypeInfo(InsertDonorTypeDto req){

        DonorType donorType = new DonorType();
        donorType.setDonorName(req.getDonorName());
        donorType.setCreatedAt(LocalDateTime.now());
        donorType.setCreatedBy(1L);
        return donorTypeRepository.save(donorType);
    }

    public List<DonorType> selectDonorTypeInfo(){
        return donorTypeRepository.findAll();
    }

    public Optional<DonorType> selectDonorTypeInfoById(Long id){
        return donorTypeRepository.findById(id);
    }

    public DonorType updateDonorTypeInfo(InsertDonorTypeDto req, Long id){
        Optional<DonorType> donorType = donorTypeRepository.findById(id);
        if(donorType.isPresent()){
            DonorType donorType1 = donorType.get();
            donorType1.setDonorName(req.getDonorName());
            donorType1.setUpdatedAt(LocalDateTime.now());
            donorType1.setUpdatedBy(2L);
            return donorTypeRepository.save(donorType1);
        }else {
            return null;
        }

    }
}
