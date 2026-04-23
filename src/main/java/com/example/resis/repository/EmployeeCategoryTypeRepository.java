package com.example.resis.repository;

import com.example.resis.model.EmployeeCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCategoryTypeRepository extends JpaRepository<EmployeeCategoryType, Long> {
}
