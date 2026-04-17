package com.example.resis.controller;

import com.example.resis.dto.InsertMembershipTypeDto;
import com.example.resis.model.MembershipType;
import com.example.resis.service.MembershipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/membershipType")
public class MembershipTypeController {

    @Autowired
    private MembershipTypeService membershipTypeService;

    @PostMapping
    public MembershipType insertMemberShipType(@RequestBody InsertMembershipTypeDto req){
        return membershipTypeService.insertMemberShipType(req);
    }

    @GetMapping
    public List<MembershipType> selectMembershipType(){
        return membershipTypeService.selectMembershipType();
    }

    @GetMapping("/{id}")
    public Optional<MembershipType> selectMembershipTypeById(@PathVariable Long id){
        return membershipTypeService.selectMembershipTypeById(id);
    }

    @PutMapping("/{id}")
    public MembershipType updateMembershipTypeInfo(@RequestBody InsertMembershipTypeDto req, @PathVariable Long id){
        return membershipTypeService.updateMembershipTypeInfo(req,id);
    }
}
