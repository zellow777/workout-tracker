package com.example.workouttracker.repository;

import com.example.workouttracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
