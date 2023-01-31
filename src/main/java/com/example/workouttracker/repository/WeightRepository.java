package com.example.workouttracker.repository;

import com.example.workouttracker.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Long> {
}