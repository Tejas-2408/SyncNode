package com.example.syncnode.repository;

import com.example.syncnode.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}

