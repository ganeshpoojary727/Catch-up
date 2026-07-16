package com.catchup.service;

import com.catchup.dto.CreateCommentRequest;
import com.catchup.entity.Comment;

import java.util.List;

public interface CommentService {

    void createComment(Long eventId, CreateCommentRequest request);

    List<Comment> getCommentsByEvent(Long eventId);

    void deleteComment(Long commentId);

}