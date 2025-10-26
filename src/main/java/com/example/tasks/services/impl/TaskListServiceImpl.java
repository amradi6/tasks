package com.example.tasks.services.impl;

import com.example.tasks.domains.entites.TaskList;
import com.example.tasks.repositorie.TaskListRepository;
import com.example.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskList() {
        return taskListRepository.findAll();
    }

    LocalDateTime now=LocalDateTime.now();
    @Override
    public TaskList createTaskList(TaskList taskList) {
        if(null!=taskList.getId()){
            throw new  IllegalArgumentException("Task List already has on id!");
        }
        if(null ==taskList.getTitle() || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("Task List tittle must be present!");
        }
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(TaskList taskList, UUID taskListId) {
        if(null == taskList.getId()){
            throw new IllegalArgumentException("Task List must have an ID");
        }
        if(!Objects.equals(taskList.getId(),taskListId)){
            throw new IllegalArgumentException("Attempting to change task list Id, this is not permitted!");
        }
       TaskList existingListId = taskListRepository.findById(taskListId).orElseThrow(() -> new IllegalArgumentException("Task List not found"));
        existingListId.setTitle(taskList.getTitle());
        existingListId.setDescription(taskList.getDescription());
        existingListId.setUpdated(LocalDateTime.now());
        existingListId.setUpdated(LocalDateTime.now());
        return  taskListRepository.save(existingListId);
    }

    @Override
    public void deleteTaskList(UUID taskListId) {
        taskListRepository.deleteById(taskListId);
    }
}
