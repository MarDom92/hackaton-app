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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/public")
    public List<EventDTO> getAllPublicEvents() {
        return eventService.getEventsByEventType(EventType.PUBLIC);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/user-events/{id}")
    public List<EventDTO> getAllMyEvents(@PathVariable("id") Long id) {
        return eventService.getAllUserEvents(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public EventDTO getEventById(@PathVariable("id") Long id) {
        return eventService.getEventById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/participate/{id}")
    public List<EventDTO> getEventsWithUserInRegistrants(@PathVariable("id") Long id) {
        return eventService.getEventsWithUserInRegistrants(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/cancel/{id}")
    public boolean cancelEvent(@PathVariable("id") Long id) {
        return eventService.cancelEvent(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/create-event",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEvent(@RequestBody EventDTO eventDTO) {
        eventService.saveEventToDB(eventDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/update-event",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEvent(@RequestBody EventDTO eventDTO) {
      eventService.updateEvent(eventDTO);
    }
}

