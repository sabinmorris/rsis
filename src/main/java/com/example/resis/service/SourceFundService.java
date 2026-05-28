package com.example.resis.service;

import com.example.resis.dto.InsertDonorTypeDto;
import com.example.resis.dto.SourceFundDto;
import com.example.resis.dto.SourceFundResponseDto;
import com.example.resis.model.DonorType;
import com.example.resis.model.SourceFund;
import com.example.resis.repository.DonorTypeRepository;
import com.example.resis.repository.SourceFundRepository;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SourceFundService {
    @Autowired
    private SourceFundRepository sourceFundRepository;
    @Autowired
    private DonorTypeRepository donorTypeRepository;

    public SourceFund insertSourceFundInfo(SourceFundDto req){
        SourceFund sourceFund = new SourceFund();
        sourceFund.setSourceFundName(req.getSourceFundName());
        // FETCH donor type from database
        DonorType donorType = donorTypeRepository.findById(req.getDonorTypeId())
                .orElseThrow(() -> new RuntimeException("Donor Type not found"));
        // SET relation
        sourceFund.setDonorType(donorType);
        sourceFund.setCreatedBy(1L);
        sourceFund.setCreatedAt(LocalDateTime.now());

        return sourceFundRepository.save(sourceFund);

    }

    public List<SourceFund> selectSourceFundInfo(){
        return sourceFundRepository.findAll();
    }

    public Optional<SourceFund> selectSourceFundInfoById(Long id){
        return sourceFundRepository.findById(id);
    }

    public SourceFundResponseDto getSourceFund(Long id){

        SourceFund sourceFund = sourceFundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        SourceFundResponseDto dto = new SourceFundResponseDto();

        dto.setSourceFundId(sourceFund.getSourceFundId());

        dto.setSourceFundName(sourceFund.getSourceFundName());

        InsertDonorTypeDto donorDto = new InsertDonorTypeDto();

        donorDto.setDonorTypeId(
                sourceFund.getDonorType().getDonorTypeId()
        );

        donorDto.setDonorName(
                sourceFund.getDonorType().getDonorName()
        );

        dto.setDonorType(donorDto);

        return dto;
    }

    public SourceFund updateSourceFundInfo(SourceFundDto req, Long id){

        Optional<SourceFund> sourceFund = sourceFundRepository.findById(id);

        if (sourceFund.isPresent()){
            SourceFund sourceFund1 = sourceFund.get();
            sourceFund1.setSourceFundName(req.getSourceFundName());
            // FETCH donor type from database
            DonorType donorType = donorTypeRepository.findById(req.getDonorTypeId())
                    .orElseThrow(() -> new RuntimeException("Donor Type not Found"));
            sourceFund1.setDonorType(donorType);
            sourceFund1.setUpdateBy(2L);
            sourceFund1.setUpdatedAt(LocalDateTime.now());
            return sourceFundRepository.save(sourceFund1);

        }else {
            return null;
        }
    }
}
