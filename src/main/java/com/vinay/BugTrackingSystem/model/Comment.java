package com.vinay.BugTrackingSystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;  // The user who made the comment

  @ManyToOne
  @JoinColumn(name = "bug_id")
  private Bug bug;  // The bug this comment is associated with

  private LocalDateTime createdAt;  // Timestamp for when the comment was created

  // Constructors, getters, setters...
}

