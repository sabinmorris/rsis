package com.example.resis.service;

import com.example.resis.dto.InsertMembershipTypeDto;
import com.example.resis.model.MembershipType;
import com.example.resis.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MembershipTypeService {

    @Autowired
   private MembershipTypeRepository membershipTypeRepository;

    //function to insert data of membership type
    public MembershipType insertMemberShipType(InsertMembershipTypeDto req){

        MembershipType membershipType = new MembershipType();
        membershipType.setMembershipName(req.getMembershipName());
        membershipType.setCreatedBy(1L);
        membershipType.setCreatedAt(LocalDateTime.now());
        return membershipTypeRepository.save(membershipType);

    }

    //function to select by all
    public List<MembershipType> selectMembershipType(){
        return membershipTypeRepository.findAll();
    }

    //function to select byId from membership table
    public Optional<MembershipType> selectMembershipTypeById(Long id){
        return membershipTypeRepository.findById(id);
    }

    //function to update membershipType info
    public MembershipType updateMembershipTypeInfo(InsertMembershipTypeDto req, Long id){

        Optional<MembershipType> membershipType = membershipTypeRepository.findById(id);

        if (membershipType.isPresent()){
            MembershipType membershipType1 = membershipType.get();
            membershipType1.setMembershipName(req.getMembershipName());
            membershipType1.setUpdatedBy(2L);
            membershipType1.setUpdatedAt(LocalDateTime.now());
            return membershipTypeRepository.save(membershipType1);
        }else {
            return null;
        }
    }

}
