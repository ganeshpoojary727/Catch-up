package com.catchup.service.impl;
import com.catchup.dto.CreateEventRequest;
import com.catchup.dto.EventResponse;
import com.catchup.dto.UserResponse;
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
    }
    @Override
    public List<EventResponse> getAllEvents() {

        return eventRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public EventResponse getEventById(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return mapToResponse(event);
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
    public List<EventResponse> searchEvents(String keyword) {

        return eventRepository
                .findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public List<EventResponse> getMyEvents() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return eventRepository.findByCreatedBy(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public List<EventResponse> getEventsByCategory(String category) {

        return eventRepository.findByCategory(category)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public List<EventResponse> getTrendingEvents() {

        return eventRepository
                .findTrendingEvents()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    private EventResponse mapToResponse(Event event) {

        EventResponse response = new EventResponse();

        response.setId(event.getId());
        response.setTitle(event.getTitle());
        response.setDescription(event.getDescription());
        response.setLocation(event.getLocation());
        response.setEventDate(event.getEventDate());
        response.setCategory(event.getCategory());
        response.setImageUrl(event.getImageUrl());

        response.setInterestedCount(event.getInterestedCount());
        response.setGoingCount(event.getGoingCount());
        response.setCommentCount(event.getCommentCount());

        response.setCreatedAt(event.getCreatedAt());

        if (event.getCreatedBy() != null) {

            UserResponse userResponse = new UserResponse();

            userResponse.setId(event.getCreatedBy().getId());
            userResponse.setUsername(event.getCreatedBy().getUsername());
            userResponse.setProfilePicture(event.getCreatedBy().getProfilePicture());

            response.setCreatedBy(userResponse);
        }

        return response;
    }
}