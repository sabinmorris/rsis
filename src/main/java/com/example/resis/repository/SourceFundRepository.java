package com.example.resis.repository;

import com.example.resis.model.SourceFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceFundRepository extends JpaRepository<SourceFund, Long> {
}
