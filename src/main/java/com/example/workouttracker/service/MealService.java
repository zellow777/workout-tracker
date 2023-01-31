package com.example.workouttracker.service;

import com.example.workouttracker.model.Meal;

import java.util.List;

public interface MealService {
    Meal saveMeal(Meal meal);
    Meal findMealById(Long id);
    List<Meal> findAllMeals();
    void deleteMeal(Long id);

    Meal updateMeal(Long id, Meal updatedMeal);
}

