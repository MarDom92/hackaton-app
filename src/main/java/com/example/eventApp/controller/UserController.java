package com.example.eventApp.controller;

import com.example.eventApp.model.dto.UserDTO;
import com.example.eventApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // ToDo: List<UserDTO> importLDAPUsers();
    // ToDo: ResponseEntity<Void> login(UserRequest request); -> login, password
}