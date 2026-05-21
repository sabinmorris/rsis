package com.example.resis.controller;

import com.example.resis.dto.SourceFundDto;
import com.example.resis.model.SourceFund;
import com.example.resis.service.SourceFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/sourcefund")
public class SourceFundController {
    @Autowired
    private SourceFundService sourceFundService;

    @PostMapping
    public SourceFund insertSourceFundInfo(@RequestBody SourceFundDto req){
        return sourceFundService.insertSourceFundInfo(req);
    }

    @GetMapping
    public List<SourceFund> selectSourceFundInfo(){
        return sourceFundService.selectSourceFundInfo();
    }

    @GetMapping("/{id}")
    public Optional<SourceFund> selectSourceFundInfoById(@PathVariable Long id){
        return sourceFundService.selectSourceFundInfoById(id);
    }

    @PutMapping("/{id}")
    public SourceFund updateSourceFundInfo(@RequestBody SourceFundDto req, @PathVariable Long id){
        return sourceFundService.updateSourceFundInfo(req, id);
    }
}
