package com.example.workouttracker.service;

import com.example.workouttracker.model.Progress;

import java.util.List;

public interface ProgressService {
    Progress saveProgress(Progress progress);
    Progress findProgressById(Long id);
    List<Progress> findAllProgress();
    void deleteProgress(Long id);

    Progress updateProgress(Long id, Progress progress);
}

