package com.catchup.repository;

import com.catchup.entity.Event;
import com.catchup.entity.GoingEvent;
import com.catchup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoingRepository extends JpaRepository<GoingEvent, Long> {

    List<GoingEvent> findByUser(User user);

    List<GoingEvent> findByEvent(Event event);

    Optional<GoingEvent> findByUserAndEvent(User user, Event event);
}