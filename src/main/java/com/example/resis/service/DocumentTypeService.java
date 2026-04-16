package com.example.resis.service;

import com.example.resis.dto.InsertDocumentTypeDto;
import com.example.resis.dto.InsertPositionDto;
import com.example.resis.model.DocumentType;
import com.example.resis.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public DocumentType insertDocumentTypeInfo(InsertDocumentTypeDto req){

        DocumentType documentType = new DocumentType();
        documentType.setDocumentName(req.getDocumentName());
        documentType.setCreatedAt(LocalDateTime.now());
        documentType.setCreateBy(1L);
        return documentTypeRepository.save(documentType);
    }

    public List<DocumentType> selectDocumentTypeInfo(){
        return documentTypeRepository.findAll();
    }

    public Optional<DocumentType> selectDocumentTypeByIdInfo(Long id){
        return documentTypeRepository.findById(id);
    }

    public DocumentType updateDocumentTypeInfo(InsertDocumentTypeDto req, Long id){

        Optional<DocumentType> documentType = documentTypeRepository.findById(id);
        if (documentType.isPresent()){
            DocumentType documentType1 = documentType.get();
            documentType1.setDocumentName(req.getDocumentName());
            documentType1.setUpdatedAt(LocalDateTime.now());
            documentType1.setCreateBy(2L);
            return documentTypeRepository.save(documentType1);
        }else{
            return null;
        }
    }
}
