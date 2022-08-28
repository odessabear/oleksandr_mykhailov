package com.epam.spring.webprovider.service;

import com.epam.spring.webprovider.controller.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(String email);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(String email, UserDTO userDTO);

    void blockUser(String email);

    void unblockUser(String email);

    void deleteUser(String email);
}
