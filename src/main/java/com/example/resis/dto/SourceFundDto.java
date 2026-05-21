package com.example.resis.dto;

import com.example.resis.model.DonorType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SourceFundDto {
    private String sourceFundName;
    private Long donorTypeId;

}
