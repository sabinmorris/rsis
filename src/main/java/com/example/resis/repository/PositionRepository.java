package com.example.resis.repository;

import com.example.resis.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//This is used to generate all CRUD queries.
@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {
}
