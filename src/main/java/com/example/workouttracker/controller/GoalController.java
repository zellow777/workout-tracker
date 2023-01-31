package com.example.workouttracker.controller;

import com.example.workouttracker.model.Goal;
import com.example.workouttracker.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout-tracking_api/goals")
public class GoalController {

    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public ResponseEntity<List<Goal>> getAll() {
        List<Goal> goals = goalService.getAllGoals();
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Goal> getById(@PathVariable Long Id) {
        Goal goal = goalService.getGoalById(Id);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Goal> save(@RequestBody Goal goal) {
        Goal createdGoal = goalService.createGoal(goal);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Goal> update(@PathVariable Long Id, @RequestBody Goal updatedGoal) {
        Goal goal = goalService.updateGoal(Id, updatedGoal);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id) {
        goalService.deleteGoal(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

