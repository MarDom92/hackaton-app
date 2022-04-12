package com.example.eventApp.controller;

import com.example.eventApp.model.dto.EventDTO;
import com.example.eventApp.model.enums.EventType;
import com.example.eventApp.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @GetMapping("/public")
    public List<EventDTO> getAllPublicEvents() {
        return eventService.getEventsByEventType(EventType.PUBLIC);
    }

    @GetMapping(path = "/user-events/{id}")
    public List<EventDTO> getAllMyEvents(@PathVariable("id") Long id) {
        return eventService.getAllUserEvents(id);
    }

    @GetMapping(path = "/{id}")
    public EventDTO getEventById(@PathVariable("id") Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping(path = "/participate/{id}")
    public List<EventDTO> getEventsWithUserInRegistrants(@PathVariable("id") Long id) {
        return eventService.getEventsWithUserInRegistrants(id);
    }

    @GetMapping(path = "/cancel/{id}")
    public boolean cancelEvent(@PathVariable("id") Long id) {
        return eventService.cancelEvent(id);
    }


}

