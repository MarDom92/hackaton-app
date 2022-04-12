package com.example.eventApp.model.dto;

import com.example.eventApp.model.entity.Comment;
import com.example.eventApp.model.entity.User;
import com.example.eventApp.model.enums.EventStatus;
import com.example.eventApp.model.enums.EventType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    private long id;
    private UserDTO userDTO;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private LocalDateTime dateOfEventStart;
    private EventStatus eventStatus;
    private EventType eventType;
    private List<UserDTO> registrants;
    private List<UserDTO> whitelist;
    private List<CommentDTO> comments;
}