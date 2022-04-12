package com.example.eventApp.controller;

import com.example.eventApp.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {

//    @PostMapping("/{eventId}")
//    public List<UserDTO> addToWhitelist(@PathVariable long eventId,
//                                        @RequestParam long userId) {
//
//    }

    // ToDo: EventDTO createEvent(ToDo: add params);
    // ToDo: List<EventDTO> getEventsByAuthorId(@PathVariable long authorId);
    // ToDo: List<EventDTO> getEventByStatus(@PathVariable long userId, @PathVariable String EventStatus)
    // ToDo: void registerUserOnEvent (@PathVariable long userId); (write user to List<user> registrants
    // ToDo: List<EventDTO> getEventsAvailable(@PathVariable long authorId);

}
