package com.example.workouttracker.service;

import com.example.workouttracker.model.Food;

import java.util.List;

public interface FoodService {
    Food saveFood(Food food);
    Food findFoodById(Long id);
    List<Food> findAllFoods();
    void deleteFood(Long id);

    Food updateFood(Long id, Food food);
}

