package com.example.syncnode.repository;

import com.example.syncnode.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long> {
    List<TaskHistory> findByTaskIdOrderByEditedAtDesc(Long taskId);
}
