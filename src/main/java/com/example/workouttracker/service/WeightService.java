package com.example.workouttracker.service;

import com.example.workouttracker.model.Weight;

import java.util.List;

public interface WeightService {
    Weight saveWeight(Weight weight);
    Weight findWeightById(Long id);
    List<Weight> findAllWeights();
    void deleteWeight(Long id);

    Weight updateWeight(Long id, Weight weight);
}
