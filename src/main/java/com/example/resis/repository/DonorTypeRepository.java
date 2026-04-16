package com.example.resis.repository;

import com.example.resis.model.DonorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorTypeRepository extends JpaRepository<DonorType, Long> {
}
