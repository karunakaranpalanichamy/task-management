package com.karuna.task.controller;

import com.karuna.task.dto.TaskDto;
import com.karuna.task.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto) {
        TaskDto savedTask = taskService.addTask(taskDto);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long taskId) {
        TaskDto taskDto = taskService.getTask(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> taskDtoList = taskService.getAllTasks();
        return new ResponseEntity<>(taskDtoList, HttpStatus.OK);
    }

    @PutMapping("/tasks")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto task) {
        TaskDto updatedTask = taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted");
    }

    @PatchMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> completeTask(@PathVariable("id") Long taskId) {
        TaskDto completedTask = taskService.completeOrInCompleteTask(taskId);
        return ResponseEntity.ok(completedTask);
    }

}
