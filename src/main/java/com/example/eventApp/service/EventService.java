package com.example.eventApp.service;

import com.example.eventApp.model.dto.EventDTO;
import com.example.eventApp.model.entity.Event;
import com.example.eventApp.model.enums.EventType;
import com.example.eventApp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    public List<EventDTO> getEventsByEventType(EventType eventType) {
        List<Event> events = eventRepository.findAllByEventType(eventType);
        return events.stream().map(event -> modelMapper.map(event,EventDTO.class)).collect(Collectors.toList());
    }

    public List<EventDTO> getAllUserEvents(Long id) {
        List<Event> events = eventRepository.findEventByAuthor_Id(id);
        return events.stream().map(event -> modelMapper.map(event,EventDTO.class)).collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            return modelMapper.map(event, EventDTO.class);
        }else{
            return null;
        }
    }


    public List<EventDTO> getEventsWithUserInRegistrants(Long id) {
        List<Event> events = eventRepository.findAllByEventRegistrantsUserId(id);
        return events.stream().map(event -> modelMapper.map(event,EventDTO.class)).collect(Collectors.toList());
    }
}
