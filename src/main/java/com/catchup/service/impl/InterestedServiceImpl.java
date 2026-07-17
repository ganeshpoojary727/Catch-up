package com.catchup.service.impl;

import com.catchup.entity.Event;
import com.catchup.entity.InterestedEvent;
import com.catchup.entity.User;
import com.catchup.exceptions.UserNotFoundException;
import com.catchup.repository.EventRepository;
import com.catchup.repository.InterestedRepository;
import com.catchup.repository.UserRepository;
import com.catchup.service.InterestedService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestedServiceImpl implements InterestedService {

    private final InterestedRepository interestedRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Override
    public void markInterested(Long eventId) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() ->
                        new RuntimeException("Event not found"));

        if (interestedRepository.findByUserAndEvent(user, event).isPresent()) {
            return;
        }

        InterestedEvent interestedEvent = new InterestedEvent();

        interestedEvent.setUser(user);
        interestedEvent.setEvent(event);

        interestedRepository.save(interestedEvent);

        System.out.println("Before increment = " + event.getInterestedCount());

        event.setInterestedCount(event.getInterestedCount() + 1);

        System.out.println("After increment = " + event.getInterestedCount());

        eventRepository.save(event);

        System.out.println("Saved successfully");

    }

    @Override
    public List<Event> getMyInterestedEvents() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        List<InterestedEvent> interestedEvents =
                interestedRepository.findByUser(user);

        List<Event> events = new ArrayList<>();

        for (InterestedEvent interestedEvent : interestedEvents) {
            events.add(interestedEvent.getEvent());
        }

        return events;
    }
}