package com.example.resis.controller;

import com.example.resis.dto.InsertIdentificationDto;
import com.example.resis.model.Identification;
import com.example.resis.service.IdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/identification")
public class IdentificationController {

    @Autowired
    private IdentificationService identificationService;

    @PostMapping
    public Identification insertIdentificationInfo(@RequestBody InsertIdentificationDto req){
        return  identificationService.insertIdentificationInfo(req);
    }

    @GetMapping
    public List<Identification> selectIdentificationInfo(){
        return identificationService.selectIdentificationInfo();
    }

    @GetMapping("/{id}")
    public Optional<Identification> selectIdentificationInfoById(@PathVariable Long id){
        return identificationService.selectIdentificationInfoById(id);
    }

    @PutMapping("/{id}")
    public Identification updateIdentificationInfo(@RequestBody InsertIdentificationDto req, @PathVariable Long id){
        return identificationService.updateIdentificationInfo(req, id);

    }
}
