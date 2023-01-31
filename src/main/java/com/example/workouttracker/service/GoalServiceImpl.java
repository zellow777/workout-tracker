package com.example.workouttracker.service;

import com.example.workouttracker.exceptions.ResourceNotFoundException;
import com.example.workouttracker.model.Goal;
import com.example.workouttracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {
    private final GoalRepository goalRepository;

    @Autowired
    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public Goal getGoalById(Long id) {
        return goalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @Override
    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }

    @Override
    public Goal updateGoal(Long goalId, Goal updatedGoal) {
        Goal goal = goalRepository.findById(goalId).orElseThrow(() -> new ResourceNotFoundException("Goal not found"));
        goal.setDescription(updatedGoal.getDescription());
        goal.setTargetDate(updatedGoal.getTargetDate());
        goal.setTargetWeight(updatedGoal.getTargetWeight());
        goal.setUser(updatedGoal.getUser());
        return goalRepository.save(goal);
    }
}

