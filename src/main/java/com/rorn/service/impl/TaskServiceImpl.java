package com.rorn.service.impl;

import com.rorn.entity.Task;
import com.rorn.exception.TaskNotFoundException;
import com.rorn.repository.TaskRepository;
import com.rorn.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task findById(UUID id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
    }

    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(UUID id, Task updatedTask) {
        Task task = findById(id);

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setPriority(updatedTask.getPriority());
        task.setDeadline(updatedTask.getDeadline());

        return taskRepository.save(task);
    }

    @Override
    public void deleteById(UUID id) {
        Task task = findById(id);
        taskRepository.delete(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

}
