package com.example.workouttracker.controller;

import com.example.workouttracker.model.Meal;
import com.example.workouttracker.service.MealService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout-tracking_api/meals")
public class MealController {
    String endPoint = "/workout-tracking_api/meals";
    private static final Logger logger = LogManager.getLogger(MealController.class);
    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public ResponseEntity<List<Meal>> findAll() {
        logger.info("FindAll() called at ");
        List<Meal> meals = mealService.findAllMeals();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Meal> findById(@PathVariable Long Id) {
        logger.info("FindByID called at " + endPoint);
        Meal meal = mealService.findMealById(Id);
        return new ResponseEntity<>(meal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Meal> create(@RequestBody Meal meal) {
        logger.info("create() called at " + endPoint);
        Meal createdMeal = mealService.saveMeal(meal);
        return new ResponseEntity<>(createdMeal, HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Meal> update(@PathVariable Long Id, @RequestBody Meal updatedMeal) {
        logger.info("update() called at " + endPoint);
        Meal meal = mealService.updateMeal(Id, updatedMeal);
        return new ResponseEntity<>(meal, HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id) {
        logger.info("delete() called at " + endPoint);
        mealService.deleteMeal(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

