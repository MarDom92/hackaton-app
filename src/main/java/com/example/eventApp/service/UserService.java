package com.example.eventApp.service;

import com.example.eventApp.model.dto.UserDTO;
import com.example.eventApp.model.entity.Event;
import com.example.eventApp.model.entity.User;
import com.example.eventApp.repositories.EventRepository;
import com.example.eventApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private EventRepository eventRepository;
    private PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       ModelMapper modelMapper) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    public void addRegistrantToEvent(Long userId, Long eventId) {
        List<Event> events = eventRepository.findAll();
        for (Event e : events
        ) {
            if (e.getId() == eventId) {
                e.getRegistrants().add(userRepository.getById(userId));
            }
        }
    }
}
