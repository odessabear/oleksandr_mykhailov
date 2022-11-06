package com.epam.spring.webprovider.controller;

import com.epam.spring.webprovider.controller.dto.UserDTO;
import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.controller.dto.group.OnUpdate;
import com.epam.spring.webprovider.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/takogonet/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getAllUsers() {
        log.info(this.getClass().getSimpleName() + " getAllUsers() method");
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        log.info("getUser by email {}", email);
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO userDTO) {
        log.info(this.getClass().getSimpleName() + " createUser() method");
        return userService.createUser(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public UserDTO updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserDTO userDTO) {
        log.info("updateUser by email {}", email);
        return userService.updateUser(email, userDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        log.info("deleteUser with email {}", email);
        userService.deleteUser(email);
    }
}
