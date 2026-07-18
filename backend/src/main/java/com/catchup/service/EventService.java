package com.catchup.service;

import com.catchup.dto.CreateEventRequest;
import com.catchup.dto.EventResponse;
import com.catchup.entity.Event;

import java.util.List;

public interface EventService {

    void createEvent(CreateEventRequest request);

    public List<EventResponse> getAllEvents();

    EventResponse getEventById(Long id);

    void updateEvent(Long id, CreateEventRequest request);

    void deleteEvent(Long id);

    List<EventResponse> searchEvents(String keyword);

    List<EventResponse> getEventsByCategory(String category);

    List<EventResponse> getMyEvents();

    List<EventResponse> getTrendingEvents();
}