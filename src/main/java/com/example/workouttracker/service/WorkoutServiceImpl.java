package com.example.workouttracker.service;

import com.example.workouttracker.model.Workout;
import com.example.workouttracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Override
    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public Workout updateWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public void deleteWorkout(Long workoutId) {
        workoutRepository.deleteById(workoutId);
    }

    @Override
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout getWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId).orElse(null);
    }
}

