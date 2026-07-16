package com.catchup.service;

import com.catchup.entity.Event;

import java.util.List;

public interface GoingService {

    void markGoing(Long eventId);

    List<Event> getMyGoingEvents();
}