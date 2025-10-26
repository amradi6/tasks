package com.example.tasks.controllers;

import com.example.tasks.domains.dto.TaskDto;
import com.example.tasks.domains.dto.TaskListDto;
import com.example.tasks.domains.entites.Task;
import com.example.tasks.domains.entites.TaskList;
import com.example.tasks.mappers.TaskListMapper;
import com.example.tasks.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/task-lists")
public class TaskListController {

    private final TaskListService taskListService;

    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }


    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskList().stream().map(taskListMapper::toDto).toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList = taskListService.createTaskList(taskListMapper.fromDto(taskListDto));
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping(path = "/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListId) {
        return taskListService.getTaskList(taskListId).map(taskListMapper::toDto);
    }

    @PutMapping(path = "/{task_list_id}")
    public TaskListDto updateTaskList(@PathVariable("task_list_id") UUID taskListID, @RequestBody TaskListDto taskListDto) {
      TaskList updatedTaskList = taskListService.updateTaskList(taskListMapper.fromDto(taskListDto), taskListID);
      return taskListMapper.toDto(updatedTaskList);
    }

    @DeleteMapping(path = "/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") UUID taskListId){
        taskListService.deleteTaskList(taskListId);
    }
}
