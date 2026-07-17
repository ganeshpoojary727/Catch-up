package com.catchup.service.impl;
import com.catchup.dto.CreateEventRequest;
import com.catchup.entity.Event;
import com.catchup.entity.User;
import com.catchup.exceptions.UserNotFoundException;
import com.catchup.repository.EventRepository;
import com.catchup.repository.UserRepository;
import com.catchup.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
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
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        event.setCreatedBy(user);

        eventRepository.save(event);
        event.setInterestedCount(event.getInterestedCount() + 1);
        eventRepository.save(event);

    }
    @Override
    public List<Event> getAllEvents() {

        return eventRepository.findAll();

    }
    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }
    @Override
    public void updateEvent(Long id, CreateEventRequest request) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setLocation(request.getLocation());
        event.setEventDate(request.getEventDate());
        event.setCategory(request.getCategory());
        event.setImageUrl(request.getImageUrl());

        eventRepository.save(event);
    }
    @Override
    public void deleteEvent(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        eventRepository.delete(event);
    }
    @Override
    public List<Event> searchEvents(String keyword) {
        return eventRepository.findByTitleContainingIgnoreCase(keyword);
    }
    @Override
    public List<Event> getEventsByCategory(String category) {
        return eventRepository.findByCategoryIgnoreCase(category);
    }
    @Override
    public List<Event> getMyEvents() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return eventRepository.findByCreatedBy(user);
    }
}