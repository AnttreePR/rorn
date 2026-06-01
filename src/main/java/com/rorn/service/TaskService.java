package com.rorn.service;

import com.rorn.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task findById(UUID id);
    Task createTask(Task task);
    Task updateTask(UUID id, Task task);
    void deleteById(UUID id);
    List<Task> getAllTasks();


}
