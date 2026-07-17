package com.catchup.service.impl;

import com.catchup.entity.Event;
import com.catchup.entity.GoingEvent;
import com.catchup.entity.User;
import com.catchup.exceptions.UserNotFoundException;
import com.catchup.repository.EventRepository;
import com.catchup.repository.GoingRepository;
import com.catchup.repository.UserRepository;
import com.catchup.service.GoingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoingServiceImpl implements GoingService {

    private final GoingRepository goingRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Override
    public void markGoing(Long eventId) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() ->
                        new RuntimeException("Event not found"));

        if (goingRepository.findByUserAndEvent(user, event).isPresent()) {
            return;
        }

        GoingEvent goingEvent = new GoingEvent();

        goingEvent.setUser(user);
        goingEvent.setEvent(event);

        goingRepository.save(goingEvent);

        System.out.println("Before increment = " + event.getGoingCount());

        event.setGoingCount(event.getGoingCount() + 1);

        System.out.println("After increment = " + event.getGoingCount());

        eventRepository.save(event);

        System.out.println("Saved successfully");
    }

    @Override
    public List<Event> getMyGoingEvents() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        List<GoingEvent> goingEvents = goingRepository.findByUser(user);

        List<Event> events = new ArrayList<>();

        for (GoingEvent goingEvent : goingEvents) {
            events.add(goingEvent.getEvent());
        }

        return events;
    }
}