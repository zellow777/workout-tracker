package com.example.workouttracker.service;

import com.example.workouttracker.exceptions.ResourceNotFoundException;
import com.example.workouttracker.model.Progress;
import com.example.workouttracker.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {
    private final ProgressRepository progressRepository;

    @Autowired
    public ProgressServiceImpl(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    @Override
    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    @Override
    public Progress findProgressById(Long id) {
        return progressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Progress> findAllProgress() {
        return progressRepository.findAll();
    }

    @Override
    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }

    @Override
    public Progress updateProgress(Long id, Progress updatedProgress) {
        Progress progress = progressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        progress.setDate(updatedProgress.getDate());
        progress.setUser(updatedProgress.getUser());
        progress.setWeight(updatedProgress.getWeight());
        return progressRepository.save(progress);
    }
}

