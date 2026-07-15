package com.catchup.service.impl;

import com.catchup.dto.CreateEventRequest;
import com.catchup.entity.Event;
import com.catchup.repository.EventRepository;
import com.catchup.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public void createEvent(CreateEventRequest request) {

        Event event = new Event();

        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setLocation(request.getLocation());
        event.setEventDate(request.getEventDate());
        event.setCategory(request.getCategory());
        event.setImageUrl(request.getImageUrl());

        event.setCreatedAt(LocalDateTime.now());

        eventRepository.save(event);
    }
}