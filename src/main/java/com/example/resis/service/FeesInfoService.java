package com.example.resis.service;

import com.example.resis.dto.InsertFeeInfoDto;
import com.example.resis.model.FeesInfo;
import com.example.resis.repository.FeesInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FeesInfoService {

    @Autowired
    private FeesInfoRepository feesInfoRepository;

    public FeesInfo insertFeeInfo(InsertFeeInfoDto req){
        FeesInfo feesInfo = new FeesInfo();
        feesInfo.setFeeName(req.getFeeName());
        feesInfo.setFeeAmount(req.getFeeAmount());
        feesInfo.setGfsCode(req.getGfsCode());
        feesInfo.setCratedAt(LocalDateTime.now());
        feesInfo.setCreatedBy(1L);
        return feesInfoRepository.save(feesInfo);
    }

    public List<FeesInfo> selectFeeInfo(){
        return feesInfoRepository.findAll();
    }

    public Optional<FeesInfo> selectFeeInfoById(Long id){
        return feesInfoRepository.findById(id);
    }

    public FeesInfo updateFeeInfo(InsertFeeInfoDto req, Long id){
        Optional<FeesInfo> feesInfo = feesInfoRepository.findById(id);
        if(feesInfo.isPresent()){
            FeesInfo feesInfo1 = feesInfo.get();
            feesInfo1.setFeeName(req.getFeeName());
            feesInfo1.setFeeAmount(req.getFeeAmount());
            feesInfo1.setGfsCode(req.getGfsCode());
            feesInfo1.setUpdatedAt(LocalDateTime.now());
            feesInfo1.setUpdatedBy(2L);
            return feesInfoRepository.save(feesInfo1);
        }else{
            return null;
        }
    }

}
