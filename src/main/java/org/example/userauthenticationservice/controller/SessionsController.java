package org.example.userauthenticationservice.controller;

import org.example.userauthenticationservice.DTO.UserDTO;
import org.example.userauthenticationservice.mapper.MapperUtil;
import org.example.userauthenticationservice.model.Session;
import org.example.userauthenticationservice.model.User;
import org.example.userauthenticationservice.service.SessionService;
import org.example.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class SessionsController {
    @Autowired
    SessionService sessionService;
    @Autowired
    MapperUtil mapperUtil;

    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        sessionService.createSession(mapperUtil.mapperFromUserDToToUser(userDTO));
        return ResponseEntity.ok("Successfully logged in");

    }

    @PostMapping("/logout")
    ResponseEntity<String> logout(@RequestParam long sessionId) {
        sessionService.deleteSession(sessionId);
        return ResponseEntity.ok("Session successfully deleted");
    }

}
