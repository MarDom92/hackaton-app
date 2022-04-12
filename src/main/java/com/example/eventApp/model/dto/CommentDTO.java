package com.example.eventApp.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private long id;
    private UserDTO userDTO;
    private EventDTO eventDTO;
}