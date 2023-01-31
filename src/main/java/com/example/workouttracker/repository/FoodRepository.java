package com.example.workouttracker.repository;

import com.example.workouttracker.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}