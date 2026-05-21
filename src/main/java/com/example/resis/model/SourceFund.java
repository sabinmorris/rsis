package com.example.resis.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class SourceFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sourceFundId;
    private String sourceFundName;
    private Long createdBy;
    private Long updateBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    private Long donorTypeId; relation with donrtype
    @ManyToOne
    @JoinColumn(name = "donorType_Id")
    private DonorType donorType;


}
