package com.catchup.repository;

import com.catchup.entity.Comment;
import com.catchup.entity.Event;
import com.catchup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByEvent(Event event);

    List<Comment> findByCreatedBy(User user);
}