package com.catchup.controller;

import com.catchup.dto.CreateCommentRequest;
import com.catchup.entity.Comment;
import com.catchup.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{eventId}/comments")
    public ResponseEntity<String> createComment(
            @PathVariable Long eventId,
            @RequestBody CreateCommentRequest request) {

        commentService.createComment(eventId, request);

        return ResponseEntity.ok("Comment Added");
    }

    @GetMapping("/{eventId}/comments")
    public List<Comment> getCommentsByEvent(
            @PathVariable Long eventId) {

        return commentService.getCommentsByEvent(eventId);
    }

    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId){

        System.out.println("DELETE CONTROLLER HIT");


        commentService.deleteComment(commentId);

        return "Comment Deleted Successfully";
    }
}