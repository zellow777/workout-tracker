package com.example.workouttracker.service;

import com.example.workouttracker.model.Workout;

import java.util.List;

public interface WorkoutService {
    Workout saveWorkout(Workout workout);
    Workout updateWorkout(Workout workout);
    void deleteWorkout(Long workoutId);
    List<Workout> findAllWorkouts();
    Workout findWorkoutById(Long workoutId);

    Workout updateWorkout(Long id, Workout updatedworkout);
}

