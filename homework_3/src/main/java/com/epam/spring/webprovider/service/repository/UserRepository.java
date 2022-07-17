package com.epam.spring.webprovider.service.repository;

import com.epam.spring.webprovider.service.model.User;

import java.util.List;

public interface UserRepository {

    User getUser(String email);

    List<User> getAllUsers();

    User creatUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);
}
