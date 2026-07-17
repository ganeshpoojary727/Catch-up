package com.catchup.controller;

import com.catchup.dto.CreateEventRequest;
import com.catchup.dto.EventResponse;
import com.catchup.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.catchup.entity.Event;
import java.util.List;
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
    @GetMapping
    public List<EventResponse> getAllEvents() {

        return eventService.getAllEvents();

    }
    @GetMapping("/{id}")
    public EventResponse getEventById(@PathVariable Long id) {

        return eventService.getEventById(id);

    }
    @PutMapping("/{id}")
    public String updateEvent(
            @PathVariable Long id,
            @RequestBody CreateEventRequest request) {

        eventService.updateEvent(id, request);

        return "Event Updated Successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {

        eventService.deleteEvent(id);

        return "Event Deleted Successfully";
    }
    @GetMapping("/search")
    public List<EventResponse> searchEvents(@RequestParam String keyword) {
        return eventService.searchEvents(keyword);
    }
    @GetMapping("/category/{category}")
    public List<EventResponse> getEventsByCategory(
            @PathVariable String category) {

        return eventService.getEventsByCategory(category);

    }
    @GetMapping("/my-events")
    public List<EventResponse> getMyEvents() {
        return eventService.getMyEvents();
    }
    @GetMapping("/trending")
    public List<EventResponse> getTrendingEvents() {

        return eventService.getTrendingEvents();

    }
}