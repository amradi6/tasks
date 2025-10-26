package com.example.tasks.mappers;

import com.example.tasks.domains.dto.TaskListDto;
import com.example.tasks.domains.entites.Task;
import com.example.tasks.domains.entites.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
