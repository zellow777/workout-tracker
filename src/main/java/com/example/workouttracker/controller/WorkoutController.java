package com.example.workouttracker.controller;

import com.example.workouttracker.model.Workout;
import com.example.workouttracker.service.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/workout-tracking_api/workouts")
public class WorkoutController {

    String endPoint = "/workout-tracking_api/workouts";
    private static final Logger logger = Logger.getLogger(WorkoutController.class);
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<Workout>> findAll() {
        logger.info("FindAll() called at " + endPoint);
        List<Workout> workouts = workoutService.findAllWorkouts();
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> findById(@PathVariable Long id) {
        logger.info("FindByID called at " + endPoint);
        Workout workout = workoutService.findWorkoutById(id);
        return ResponseEntity.ok(workout);
    }

    @PostMapping
    public ResponseEntity<Workout> create(@RequestBody Workout workout) {
        logger.info("create() called at " + endPoint);
        Workout savedWorkout = workoutService.saveWorkout(workout);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workout> update(@PathVariable Long id, @RequestBody Workout workout) {
        logger.info("update() called at " + endPoint);
        Workout updatedWorkout = workoutService.updateWorkout(id, workout);
        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("delete() called at " + endPoint);
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }
}
