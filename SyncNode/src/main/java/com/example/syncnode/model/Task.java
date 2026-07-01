package com.example.syncnode.model;

// Represents the to-do items (tasks). It uses a @Version field for optimistic concurrency control to prevent edit collisions

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String bucket;
    private String status; // Pending, In Progress, Completed

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @Version
    private Long version; // prevents race condition during simultaneous edits
}
