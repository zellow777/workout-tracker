package com.example.workouttracker.service;

import com.example.workouttracker.model.Goal;

import java.util.List;

public interface GoalService {
    Goal createGoal(Goal goal);
    Goal getGoalById(Long id);
    List<Goal> getAllGoals();
    void deleteGoal(Long id);

    Goal updateGoal(Long goalId, Goal updatedGoal);
}
