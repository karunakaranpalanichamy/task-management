package com.karuna.task.service;

import com.karuna.task.dto.TaskDto;
import com.karuna.task.entity.Task;
import com.karuna.task.exception.ResourceNotFoundException;
import com.karuna.task.repository.TaskRepository;
import org.jspecify.annotations.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }

    @Override
    public TaskDto getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id:"+id));
        return modelMapper.map(task, TaskDto.class);
    }

    public List<TaskDto> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(task -> modelMapper.map(task,TaskDto.class)).toList();
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Long id = taskDto.getId();
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task is not found for id:"+id));
        Task updatedTask = modelMapper.map(taskDto, Task.class);
        Task savedTask = taskRepository.save(updatedTask);
        return modelMapper.map(savedTask,TaskDto.class);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task is not found for id:"+id));
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto completeOrInCompleteTask(Long id) {
        Task savedTask = getSavedTask(id);
        return modelMapper.map(savedTask, TaskDto.class);
    }

    private @NonNull Task getSavedTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task is not found for id:" + id));
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

}
