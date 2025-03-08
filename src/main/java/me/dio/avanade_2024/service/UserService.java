package me.dio.avanade_2024.service;

import me.dio.avanade_2024.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    User create(User userToCreate);
    List<User> findAll();
}
