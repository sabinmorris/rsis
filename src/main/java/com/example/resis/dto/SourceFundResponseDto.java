package com.example.resis.dto;

import lombok.Data;

@Data
public class SourceFundResponseDto {
    private Long sourceFundId;
    private String sourceFundName;
    private InsertDonorTypeDto donorType;
}
