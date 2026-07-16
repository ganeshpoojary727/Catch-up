package com.catchup.service;

import com.catchup.dto.CreateEventRequest;
import com.catchup.entity.Event;

import java.util.List;

public interface EventService {

    void createEvent(CreateEventRequest request);

    List<Event> getAllEvents();

    Event getEventById(Long id);

    void updateEvent(Long id, CreateEventRequest request);

    void deleteEvent(Long id);

    List<Event> searchEvents(String keyword);

    List<Event> getEventsByCategory(String category);
}