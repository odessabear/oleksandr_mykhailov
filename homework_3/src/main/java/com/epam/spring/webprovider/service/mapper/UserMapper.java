package com.epam.spring.webprovider.service.mapper;

import com.epam.spring.webprovider.controller.dto.UserDTO;
import com.epam.spring.webprovider.service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    List<UserDTO> UsersToUsersDTO(List<User> users);
}
