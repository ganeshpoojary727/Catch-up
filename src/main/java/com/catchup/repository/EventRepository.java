package com.catchup.repository;

import com.catchup.entity.Event;
import com.catchup.entity.User;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCategoryIgnoreCase(String category);

    List<Event> findByTitleContainingIgnoreCase(String keyword);

    List<Event> findByCreatedBy(User user);

    List<Event> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String title,
            String description
    );
    List<Event> findAllByOrderByInterestedCountDescGoingCountDescCommentCountDesc();
    

    List<Event> findByCategory(String category);
    @Query("""
SELECT e
FROM Event e
ORDER BY (e.interestedCount + e.goingCount + e.commentCount) DESC
""")
    List<Event> findTrendingEvents();
}