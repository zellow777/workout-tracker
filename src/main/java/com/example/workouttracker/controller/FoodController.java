package com.example.workouttracker.controller;

import com.example.workouttracker.model.Food;
import com.example.workouttracker.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/workout-tracking_api/foods")
public class FoodController {
    String endPoint = "/workout-tracking_api/foods";
    private static final Logger logger = Logger.getLogger(FoodController.class);

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<List<Food>> findAll() {
        logger.info("FindAll() called at " + endPoint);
        List<Food> foods = foodService.findAllFoods();
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> findById(@PathVariable Long id) {
        logger.info("FindByID called at " + endPoint);
        Food food = foodService.findFoodById(id);
        return ResponseEntity.ok(food);
    }

    @PostMapping
    public ResponseEntity<Food> create(@RequestBody Food food) {
        logger.info("create() called at " + endPoint);
        Food savedFood = foodService.saveFood(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFood);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> update(@PathVariable Long id, @RequestBody Food food) {
        logger.info("update() called at " + endPoint);
        Food updatedFood = foodService.updateFood(id, food);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("delete() called at " + endPoint);
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
