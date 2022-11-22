package com.epam.spring.webprovider.api;

import com.epam.spring.webprovider.controller.dto.UserDTO;
import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.controller.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "User management API")
@RequestMapping("api/v1/users")
public interface UserApi {

    @ApiOperation("Get all Users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<UserDTO> getAllUsers();

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User Email")
    })
    @ApiOperation("Get user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    UserDTO getUserByEmail(@PathVariable String email);

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO userDTO);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User Email")
    })
    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    UserDTO updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserDTO userDTO);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User Email")
    })
    @ApiOperation("Delete user")
    @DeleteMapping("/{email}")
    ResponseEntity<Void> deleteUser(@PathVariable String email);
}
