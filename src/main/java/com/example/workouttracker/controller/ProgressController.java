package com.example.workouttracker.controller;

import com.example.workouttracker.model.Progress;
import com.example.workouttracker.service.ProgressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout-tracking_api/progresses")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    public ResponseEntity<List<Progress>> findAll() {
        List<Progress>  progresses = progressService.findAllProgress();
        return ResponseEntity.ok(progresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progress> findById(@PathVariable Long id) {
        Progress progress = progressService.findProgressById(id);
        return ResponseEntity.ok(progress);
    }

    @PostMapping
    public ResponseEntity<Progress> create(@RequestBody Progress progress) {
        Progress savedProgress = progressService.saveProgress(progress);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProgress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progress> update(@PathVariable Long id, @RequestBody Progress progress) {
        Progress updatedProgress = progressService.updateProgress(id, progress);
        return ResponseEntity.ok(updatedProgress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        progressService.deleteProgress(id);
        return ResponseEntity.noContent().build();
    }
}
