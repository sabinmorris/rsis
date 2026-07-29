package com.example.resis.model;

import enumpackage.FeeType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class FeesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feeId;
    private String feeName;
    private BigDecimal feeAmount;
    private String gfsCode;
    private String feeCode;
    @Enumerated(EnumType.STRING)
    private FeeType FeeType;
    private LocalDateTime cratedAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;

}
