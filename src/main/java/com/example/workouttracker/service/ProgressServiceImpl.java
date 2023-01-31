package com.example.workouttracker.service;

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
}

