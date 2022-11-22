package com.epam.spring.webprovider.controller;

import com.epam.spring.webprovider.api.UserApi;
import com.epam.spring.webprovider.controller.dto.UserDTO;
import com.epam.spring.webprovider.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApi {

    private final UserService userService;

    public List<UserDTO> getAllUsers() {
        log.info(this.getClass().getSimpleName() + " getAllUsers() method");
        return userService.getAllUsers();
    }

    public UserDTO getUserByEmail(String email) {
        log.info("getUser by email {}", email);
        return userService.getUser(email);
    }

    public UserDTO createUser(UserDTO userDTO) {
        log.info(this.getClass().getSimpleName() + " createUser() method");
        return userService.createUser(userDTO);
    }

    public UserDTO updateUser(String email, UserDTO userDTO) {
        log.info("updateUser by email {}", email);
        return userService.updateUser(email, userDTO);
    }

    public ResponseEntity<Void> deleteUser(String email) {
        log.info("deleteUser with email {}", email);
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
