package com.example.workouttracker.controller;

import com.example.workouttracker.model.Weight;
import com.example.workouttracker.service.WeightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout-tracking_api/weight")
public class WeightController {

    private final WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping
    public ResponseEntity<List<Weight>> findAll() {
        List<Weight> weights = weightService.findAllWeights();
        return ResponseEntity.ok(weights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weight> findById(@PathVariable Long id) {
        Weight weight = weightService.findWeightById(id);
        return ResponseEntity.ok(weight);
    }

    @PostMapping
    public ResponseEntity<Weight> create(@RequestBody Weight weight) {
        Weight savedWeight = weightService.saveWeight(weight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWeight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weight> update(@PathVariable Long id, @RequestBody Weight weight) {
        Weight updatedWeight = weightService.updateWeight(id, weight);
        return ResponseEntity.ok(updatedWeight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        weightService.deleteWeight(id);
        return ResponseEntity.noContent().build();
    }
}