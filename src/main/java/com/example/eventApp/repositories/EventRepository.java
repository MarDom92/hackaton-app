package com.example.eventApp.repositories;

import com.example.eventApp.model.entity.Event;
import com.example.eventApp.model.enums.EventStatus;
import com.example.eventApp.model.enums.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByEventType(EventType eventType);

    List<Event> findAllByEventStatus(EventStatus eventStatus);

    List<Event> findEventByAuthor_Id(Long id);
}