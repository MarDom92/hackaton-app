package com.example.eventApp.service;

import com.example.eventApp.model.dto.EventDTO;
import com.example.eventApp.model.entity.Event;
import com.example.eventApp.model.entity.User;
import com.example.eventApp.model.enums.EventStatus;
import com.example.eventApp.model.enums.EventType;
import com.example.eventApp.repositories.EventRepository;
import com.example.eventApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<EventDTO> getEventsByEventType(EventType eventType) {
        List<Event> events = getPlannedEventsOnly(eventRepository.findAllByEventType(eventType));
        return events.stream().map(event -> modelMapper.map(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    public List<EventDTO> getAllUserEvents(Long id) {
        return getPlannedEventsOnly(eventRepository.findEventByAuthor_Id(id))
                .stream().map(event -> modelMapper.map(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) {
        List<Event> events = eventRepository.findAll();
        for (Event e : events
        ) {
            if (e.getId() == id) {
                return modelMapper.map(e, EventDTO.class);
            }
        }
        return null;
    }

    public List<EventDTO> getEventsWithUserInRegistrants(Long id) {
        List<Event> events = eventRepository.findAllByEventStatus(EventStatus.PLANNED);
        User user = userRepository.getById(id);
        List<Event> filtrated = new ArrayList<>();
        for (Event e : events) {
            if (e.getRegistrants().contains(user)) {
                filtrated.add(e);
            }
        }
        return filtrated.stream().map(event -> modelMapper.map(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    public boolean cancelEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);

        if (event.isPresent()&&event.get().getEventStatus().equals(EventStatus.PLANNED)) {
            event.get().setEventStatus(EventStatus.CANCELLED);
            eventRepository.save(event.get());
            return true;
        } else {
            return false;
        }
    }

    public void saveEventToDB(EventDTO eventDTO) {
        eventRepository.save(modelMapper.map(eventDTO, Event.class));
    }

    private List<Event> getPlannedEventsOnly(List<Event> eventsForCheck) {
        List<Event> events = new ArrayList<>();
        for (Event e:eventsForCheck
        ) {
            if (e.getEventStatus().equals(EventStatus.PLANNED)) {
                events.add(e);
            }
        }
        return events;
    }
}