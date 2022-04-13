package com.example.eventApp.controller;

import com.example.eventApp.model.dto.UserDTO;
import com.example.eventApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/add-me-to-event")
    public void addRegistrantToEvent(@RequestBody Long userId, Long eventId) {
        userService.addRegistrantToEvent(userId, eventId);
    }
}