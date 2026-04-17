package com.example.resis.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InsertFeeInfoDto {
    private String feeName;
    private BigDecimal feeAmount;
}
