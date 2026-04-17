package com.example.resis.controller;


import com.example.resis.dto.InsertDocumentTypeDto;
import com.example.resis.model.DocumentType;
import com.example.resis.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/documentType")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @PostMapping
    public DocumentType insertDocumentTypeInfo(@RequestBody InsertDocumentTypeDto req){
        return documentTypeService.insertDocumentTypeInfo(req);
    }

    @GetMapping
    public List<DocumentType> selectDocumentTypeInfo(){
        return documentTypeService.selectDocumentTypeInfo();
    }

    @GetMapping("/{id}")
    public Optional<DocumentType> selectDocumentTypeByIdInfo(@PathVariable Long id){
        return documentTypeService.selectDocumentTypeByIdInfo(id);
    }

    @PutMapping("/{id}")
    public DocumentType updateDocumentTypeInfo(@RequestBody InsertDocumentTypeDto req, @PathVariable Long id){
        return documentTypeService.updateDocumentTypeInfo(req, id);
    }
}
