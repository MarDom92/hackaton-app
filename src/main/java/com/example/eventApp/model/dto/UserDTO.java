package com.example.eventApp.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    //private String password;
}