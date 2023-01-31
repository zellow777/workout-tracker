package com.example.workouttracker.service;

import com.example.workouttracker.model.Workout;

import java.util.List;

public interface WorkoutService {
    Workout addWorkout(Workout workout);
    Workout updateWorkout(Workout workout);
    void deleteWorkout(Long workoutId);
    List<Workout> getAllWorkouts();
    Workout getWorkoutById(Long workoutId);
}

