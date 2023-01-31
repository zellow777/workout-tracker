package com.example.workouttracker.controller;

import com.example.workouttracker.model.Meal;
import com.example.workouttracker.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout-tracking_api/meals")
public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public ResponseEntity<List<Meal>> getAll() {
        List<Meal> meals = mealService.findAllMeals();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Meal> getById(@PathVariable Long Id) {
        Meal meal = mealService.findMealById(Id);
        return new ResponseEntity<>(meal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Meal> save(@RequestBody Meal meal) {
        Meal createdMeal = mealService.saveMeal(meal);
        return new ResponseEntity<>(createdMeal, HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Meal> update(@PathVariable Long Id, @RequestBody Meal updatedMeal) {
        Meal meal = mealService.updateMeal(Id, updatedMeal);
        return new ResponseEntity<>(meal, HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id) {
        mealService.deleteMeal(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

