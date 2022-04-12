package com.example.eventApp.service;

import com.example.eventApp.model.dto.EventDTO;
import com.example.eventApp.model.entity.Event;
import com.example.eventApp.model.enums.EventType;
import com.example.eventApp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
        List<Event> events = eventRepository.findAllByUserId(id);
        return events.stream().map(event -> modelMapper.map(event,EventDTO.class)).collect(Collectors.toList());
    }
}
