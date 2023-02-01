package com.example.workouttracker.controller;

import com.example.workouttracker.model.Goal;
import com.example.workouttracker.service.GoalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/workout-tracking_api/goals")
public class GoalController {
    String endPoint = "/workout-tracking_api/goals";
    private static final Logger logger = LogManager.getLogger(GoalController.class);
    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public ResponseEntity<List<Goal>> findAll() {
        logger.info("FindAll() called at ");
        List<Goal> goals = goalService.getAllGoals();
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Goal> findById(@PathVariable Long Id) {
        logger.info("FindByID called at " + endPoint);
        Goal goal = goalService.getGoalById(Id);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Goal> create(@RequestBody Goal goal) {
        logger.info("create() called at " + endPoint);
        Goal createdGoal = goalService.createGoal(goal);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Goal> update(@PathVariable Long Id, @RequestBody Goal updatedGoal) {
        logger.info("update() called at " + endPoint);
        Goal goal = goalService.updateGoal(Id, updatedGoal);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id) {
        logger.info("delete() called at " + endPoint);
        goalService.deleteGoal(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

