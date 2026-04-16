package com.example.resis.controller;

import com.example.resis.dto.InsertBankInfoDto;
import com.example.resis.model.Bank;
import com.example.resis.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/bankInfo")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping
    public Bank insertBankInfo(@RequestBody InsertBankInfoDto req){
        return bankService.insertBankInfo(req);
    }

    @GetMapping
    public List<Bank> selectBankInfo(){
        return bankService.selectBankInfo();
    }

    @GetMapping("/{id}")
    public Optional<Bank> selectBankInfoById(Long id){
        return bankService.selectBankInfoById(id);
    }

    @PutMapping("/{id}")
    public Bank updateBankInfo(@RequestBody InsertBankInfoDto req, Long id){
        return bankService.updateBankInfo(req, id);
    }
}
