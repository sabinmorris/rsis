package com.example.resis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class FeesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feeId;
    private String feeName;
    private double feeAmount;
    private LocalDateTime cratedAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
