package com.example.resis.service;

import com.example.resis.dto.InsertIdentificationDto;
import com.example.resis.model.Identification;
import com.example.resis.repository.IdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IdentificationService {

    @Autowired
    private IdentificationRepository identificationRepository;

    public Identification insertIdentificationInfo(InsertIdentificationDto req){

        Identification identification = new Identification();
        identification.setIdentificationName(req.getIdentificationName());
        identification.setCreatedAt(LocalDateTime.now());
        identification.setCreatedBy(1L);
        return identificationRepository.save(identification);
    }

    public List<Identification> selectIdentificationInfo(){
        return identificationRepository.findAll();
    }

    public Optional<Identification> selectIdentificationInfoById(Long id){

        return identificationRepository.findById(id);
    }

    public Identification updateIdentificationInfo(InsertIdentificationDto req, Long id){
        Optional<Identification> identification = identificationRepository.findById(id);
        if(identification.isPresent()){
            Identification identification1 = identification.get();
            identification1.setIdentificationName(req.getIdentificationName());
            identification1.setUpdatedAt(LocalDateTime.now());
            identification1.setUpdatedBy(2L);
            return identificationRepository.save(identification1);
        }else {
            return null;
        }
    }
}
