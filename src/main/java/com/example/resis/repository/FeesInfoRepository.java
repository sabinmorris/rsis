package com.example.resis.repository;

import com.example.resis.model.FeesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeesInfoRepository extends JpaRepository<FeesInfo, Long> {
    Optional<FeesInfo> findByFeeCode(String feeCode);
}
