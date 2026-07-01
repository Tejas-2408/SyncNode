package com.example.syncnode.model;

// stores historical state changes whenever a task is updated by any team member

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_history")
@Data
public class TaskHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id",nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "edited_by_user_id",nullable = false)
    private User editedBy;

    private LocalDateTime editedAt = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String changeDetails; // summarized text of what changed
}
