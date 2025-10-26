package com.example.tasks.domains.dto;

import com.example.tasks.domains.entites.TaskPriority;
import com.example.tasks.domains.entites.TaskStatus;


import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
