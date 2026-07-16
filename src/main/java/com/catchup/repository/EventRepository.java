package com.catchup.repository;

import com.catchup.entity.Event;
import com.catchup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCategoryIgnoreCase(String category);

    List<Event> findByTitleContainingIgnoreCase(String keyword);

    List<Event> findByCreatedBy(User user);
}