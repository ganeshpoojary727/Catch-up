package com.catchup.service.impl;

import com.catchup.dto.CreateCommentRequest;
import com.catchup.entity.Comment;
import com.catchup.entity.Event;
import com.catchup.entity.User;
import com.catchup.exceptions.UserNotFoundException;
import com.catchup.repository.CommentRepository;
import com.catchup.repository.EventRepository;
import com.catchup.repository.UserRepository;
import com.catchup.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Override
    public void createComment(Long eventId, CreateCommentRequest request) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() ->
                        new RuntimeException("Event not found"));

        Comment comment = new Comment();

        comment.setContent(request.getContent());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setCreatedBy(user);
        comment.setEvent(event);

        commentRepository.save(comment);

        event.setCommentCount(event.getCommentCount() + 1);
        eventRepository.save(event);
    }

    @Override
    public List<Comment> getCommentsByEvent(Long eventId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() ->
                        new RuntimeException("Event not found"));

        return commentRepository.findByEvent(event);
    }

    @Override
    public void deleteComment(Long commentId) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() ->
                        new RuntimeException("Comment not found"));

        commentRepository.delete(comment);
    }
}