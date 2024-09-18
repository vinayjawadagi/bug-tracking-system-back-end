package com.vinay.BugTrackingSystem.repository;

import com.vinay.BugTrackingSystem.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
