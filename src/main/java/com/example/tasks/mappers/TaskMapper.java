package com.example.tasks.mappers;

import com.example.tasks.domains.dto.TaskDto;
import com.example.tasks.domains.entites.Task;
import org.springframework.stereotype.Component;


public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
