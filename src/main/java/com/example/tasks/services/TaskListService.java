package com.example.tasks.services;

import com.example.tasks.domains.entites.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {

    List<TaskList> listTaskList();

    TaskList createTaskList(TaskList taskList);

    Optional<TaskList> getTaskList(UUID id);

    TaskList updateTaskList(TaskList taskList, UUID taskListId);

    void deleteTaskList(UUID taskListId);
}
