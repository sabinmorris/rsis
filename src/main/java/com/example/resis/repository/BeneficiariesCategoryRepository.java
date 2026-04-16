package com.example.resis.repository;

import com.example.resis.model.BeneficiariesCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiariesCategoryRepository extends JpaRepository<BeneficiariesCategory, Long> {
}
