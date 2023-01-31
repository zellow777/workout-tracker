package com.example.workouttracker.service;

import com.example.workouttracker.exceptions.ResourceNotFoundException;
import com.example.workouttracker.model.Workout;
import com.example.workouttracker.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public void deleteWorkout(Long workoutId) {
        workoutRepository.deleteById(workoutId);
    }

    @Override
    public List<Workout> findAllWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout findWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId).orElse(null);
    }

    @Override
    public Workout updateWorkout(Long id, Workout updatedWorkout) {
        Workout workout = workoutRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Goal not found"));
        workout.setWorkoutType(updatedWorkout.getWorkoutType());
        workout.setDescription(updatedWorkout.getDescription());
        workout.setUser(updatedWorkout.getUser());
        workout.setName(updatedWorkout.getName());
        workout.setDate(updatedWorkout.getDate());
        return workoutRepository.save(workout);
    }
}

