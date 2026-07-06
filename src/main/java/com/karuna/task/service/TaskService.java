package com.karuna.task.service;

import com.karuna.task.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);
    TaskDto getTask(Long id);
    List<TaskDto> getAllTasks();
    TaskDto updateTask(TaskDto task);
    void deleteTask(Long id);
    TaskDto completeOrInCompleteTask(Long id);

}
