package com.example.resis.dto;

import enumpackage.FeeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class InsertFeeInfoDto {
    private String feeName;
    private BigDecimal feeAmount;
    private String feeCode;
    private String subSpCode;
    private String gfsCode;
    @Enumerated(EnumType.STRING)
    private FeeType FeeType;
}
