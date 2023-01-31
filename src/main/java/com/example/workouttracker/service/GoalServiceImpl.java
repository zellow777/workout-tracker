package com.example.workouttracker.service;

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
    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public Goal findGoalById(Long id) {
        return goalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Goal> findAllGoals() {
        return goalRepository.findAll();
    }

    @Override
    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
}

