package com.example.resis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class DonorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donorTypeId;
    private String donorName;
    private LocalDateTime createdAt;
    private Long CreatedBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
