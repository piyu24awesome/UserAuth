package org.example.userauthenticationservice.controller;

import org.example.userauthenticationservice.DTO.UserDTO;
import org.example.userauthenticationservice.mapper.MapperUtil;
import org.example.userauthenticationservice.model.User;
import org.example.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    MapperUtil mapperUtil;
    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {

        if (userDTO.getEmailId() == null) {
            throw new IllegalArgumentException("Email id cannot be null");
        }

        if (userDTO.getEncPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        User createdUser = userService.addUser(mapperUtil.mapperFromUserDToToUser(userDTO));
        UserDTO userDTOReturned = mapperUtil.mapperFromUserToUserDTO(createdUser);
        return ResponseEntity.ok(userDTOReturned);
    }
}
