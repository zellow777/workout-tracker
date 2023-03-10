package com.example.workouttracker.service;

import com.example.workouttracker.exceptions.ResourceNotFoundException;
import com.example.workouttracker.model.Meal;
import com.example.workouttracker.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Meal findMealById(Long id) {
        return mealRepository.findById(id).orElse(null);
    }

    @Override
    public List<Meal> findAllMeals() {
        return mealRepository.findAll();
    }

    @Override
    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }

    @Override
    public Meal updateMeal(Long id, Meal updatedMeal) {
        Meal meal = mealRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        meal.setName(updatedMeal.getName());
        meal.setDate(updatedMeal.getDate());
        meal.setDescription(updatedMeal.getDescription());
        meal.setFoods(updatedMeal.getFoods());
        meal.setUser(updatedMeal.getUser());
        return mealRepository.save(meal);
    }
}
