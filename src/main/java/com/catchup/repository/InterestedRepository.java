package com.catchup.repository;

import com.catchup.entity.Event;
import com.catchup.entity.InterestedEvent;
import com.catchup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InterestedRepository extends JpaRepository<InterestedEvent, Long> {

    List<InterestedEvent> findByUser(User user);

    List<InterestedEvent> findByEvent(Event event);

    Optional<InterestedEvent> findByUserAndEvent(User user, Event event);
}