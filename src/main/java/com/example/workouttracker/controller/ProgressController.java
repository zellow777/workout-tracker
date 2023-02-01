package com.example.workouttracker.controller;

import com.example.workouttracker.model.Progress;
import com.example.workouttracker.service.ProgressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout-tracking_api/progresses")
public class ProgressController {
    String endPoint = "/workout-tracking_api/progresses";
    private static final Logger logger = LogManager.getLogger(ProgressController.class);
    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    public ResponseEntity<List<Progress>> findAll() {
        logger.info("FindAll() called at ");
        List<Progress>  progresses = progressService.findAllProgress();
        return ResponseEntity.ok(progresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progress> findById(@PathVariable Long id) {
        logger.info("FindByID called at " + endPoint);
        Progress progress = progressService.findProgressById(id);
        return ResponseEntity.ok(progress);
    }

    @PostMapping
    public ResponseEntity<Progress> create(@RequestBody Progress progress) {
        logger.info("create() called at " + endPoint);
        Progress savedProgress = progressService.saveProgress(progress);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProgress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progress> update(@PathVariable Long id, @RequestBody Progress progress) {
        logger.info("update() called at " + endPoint);
        Progress updatedProgress = progressService.updateProgress(id, progress);
        return ResponseEntity.ok(updatedProgress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("delete() called at " + endPoint);
        progressService.deleteProgress(id);
        return ResponseEntity.noContent().build();
    }
}
