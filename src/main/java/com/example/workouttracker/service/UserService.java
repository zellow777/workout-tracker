package com.example.workouttracker.service;

import com.example.workouttracker.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserById(Long id);
    User findUserByUsername(String username);
    List<User> findAllUsers();
    void deleteUser(Long id);
    User updateUser(Long id, User user);
}
