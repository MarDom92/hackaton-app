package com.example.eventApp.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private long id;
    private UserDTO user;
    private long eventId;
    private String comment;
    private LocalDateTime created;
}