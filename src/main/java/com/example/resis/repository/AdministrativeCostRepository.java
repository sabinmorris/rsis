package com.example.resis.repository;

import com.example.resis.model.AdministrativeCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativeCostRepository extends JpaRepository<AdministrativeCost, Long> {
}
