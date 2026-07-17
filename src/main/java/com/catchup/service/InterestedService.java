package com.catchup.service;

import com.catchup.entity.Event;

import java.util.List;

public interface InterestedService {

    void markInterested(Long eventId);

    List<Event> getMyInterestedEvents();

    void removeInterested(Long eventId);
}