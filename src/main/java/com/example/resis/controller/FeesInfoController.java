package com.example.resis.controller;

import com.example.resis.dto.InsertFeeInfoDto;
import com.example.resis.model.FeesInfo;
import com.example.resis.service.FeesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/feesInfo")
public class FeesInfoController {

    @Autowired
    private FeesInfoService feesInfoService;

    @PostMapping
    public FeesInfo insertFeeInfo(@RequestBody InsertFeeInfoDto req){
        return feesInfoService.insertFeeInfo(req);
    }

    @GetMapping
    public List<FeesInfo> selectFeeInfo(){
        return feesInfoService.selectFeeInfo();
    }

    @GetMapping("/{id}")
    public Optional<FeesInfo> selectFeeInfoById(Long id){
        return feesInfoService.selectFeeInfoById(id);
    }

    @PutMapping("/{id}")
    public FeesInfo updateFeeInfoById(@RequestBody InsertFeeInfoDto req, Long id){
        return feesInfoService.updateFeeInfo(req, id);
    }
}
