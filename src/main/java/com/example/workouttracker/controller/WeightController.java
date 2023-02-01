package com.example.workouttracker.controller;

import com.example.workouttracker.model.Weight;
import com.example.workouttracker.service.WeightService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout-tracking_api/weights")
public class WeightController {
    String endPoint = "/workout-tracking_api/weights";
    private static final Logger logger = LogManager.getLogger(WeightController.class);
    private final WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping
    public ResponseEntity<List<Weight>> findAll() {
        logger.info("FindAll() called at ");
        List<Weight> weights = weightService.findAllWeights();
        return ResponseEntity.ok(weights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weight> findById(@PathVariable Long id) {
        logger.info("FindByID called at " + endPoint);
        Weight weight = weightService.findWeightById(id);
        return ResponseEntity.ok(weight);
    }

    @PostMapping
    public ResponseEntity<Weight> create(@RequestBody Weight weight) {
        logger.info("create() called at " + endPoint);
        Weight savedWeight = weightService.saveWeight(weight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWeight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weight> update(@PathVariable Long id, @RequestBody Weight weight) {
        logger.info("update() called at " + endPoint);
        Weight updatedWeight = weightService.updateWeight(id, weight);
        return ResponseEntity.ok(updatedWeight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("delete() called at " + endPoint);
        weightService.deleteWeight(id);
        return ResponseEntity.noContent().build();
    }
}