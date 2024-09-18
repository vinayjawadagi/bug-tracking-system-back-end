package com.vinay.BugTrackingSystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="bugs")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo; // The user assigned to the bug

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy; // The user who created the bug

    @OneToMany(mappedBy = "bug")
    private List<Comment> comments;


    public Bug() {

    }
}
