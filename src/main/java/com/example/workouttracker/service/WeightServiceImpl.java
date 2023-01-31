package com.example.workouttracker.service;

import com.example.workouttracker.model.Weight;
import com.example.workouttracker.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightServiceImpl implements WeightService {
    private final WeightRepository weightRepository;

    @Autowired
    public WeightServiceImpl(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Override
    public Weight saveWeight(Weight weight) {
        return weightRepository.save(weight);
    }

    @Override
    public Weight findWeightById(Long id) {
        return weightRepository.findById(id).orElse(null);
    }

    @Override
    public List<Weight> findAllWeights() {
        return weightRepository.findAll();
    }

    @Override
    public void deleteWeight(Long id) {
        weightRepository.deleteById(id);
    }
}

