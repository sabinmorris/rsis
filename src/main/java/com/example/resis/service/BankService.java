package com.example.resis.service;

import com.example.resis.dto.InsertBankInfoDto;
import com.example.resis.model.Bank;
import com.example.resis.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public Bank insertBankInfo(InsertBankInfoDto req){

        Bank bank = new Bank();
        bank.setBankName(req.getBankName());
        bank.setCreatedAt(LocalDateTime.now());
        bank.setCreatedBy(1L);
        return bankRepository.save(bank);
    }

    public List<Bank> selectBankInfo(){
        return bankRepository.findAll();
    }

    public Optional<Bank> selectBankInfoById(Long id){
        return bankRepository.findById(id);
    }

    public Bank updateBankInfo(@RequestBody InsertBankInfoDto req, Long id){

        Optional<Bank> bank = bankRepository.findById(id);
        if(bank.isPresent()){
            Bank bank1 =  bank.get();
            bank1.setBankName(req.getBankName());
            bank1.setUpdatedAt(LocalDateTime.now());
            bank1.setUpdatedBy(2L);
            return bankRepository.save(bank1);
        }else {
            return  null;
        }
    }
}
