package com.example.workouttracker.service;

import com.example.workouttracker.model.Food;
import com.example.workouttracker.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food findFoodById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    @Override
    public List<Food> findAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
