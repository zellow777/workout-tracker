package com.example.workouttracker.service;

import com.example.workouttracker.model.Goal;

import java.util.List;

public interface GoalService {
    Goal saveGoal(Goal goal);
    Goal findGoalById(Long id);
    List<Goal> findAllGoals();
    void deleteGoal(Long id);
}
