package com.catchup.controller;

import com.catchup.dto.CreateEventRequest;
import com.catchup.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public String createEvent(@RequestBody CreateEventRequest request) {

        eventService.createEvent(request);

        return "Event Created Successfully";
    }
}