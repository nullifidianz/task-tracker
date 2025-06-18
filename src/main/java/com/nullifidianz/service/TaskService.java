package com.nullifidianz.service;

import com.nullifidianz.enums.Status;
import com.nullifidianz.model.Task;
import com.nullifidianz.repository.TaskRepository;
import com.nullifidianz.utils.ConsoleColors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TaskService {
    private final TaskRepository repository;

    public TaskService() {
        this.repository = new TaskRepository();
    }

    public void addTask(String description) {
        Task task = new Task(
                UUID.randomUUID(),
                description,
                Status.TODO,
                LocalDateTime.now(),
                LocalDateTime.now());
        repository.save(task);
        System.out.println(ConsoleColors.success("✅ Task added successfully (ID: " + task.getId() + ")"));
    }

    public void updateTask(UUID id, String newDescription) {
        Task task = repository.findById(id);
        task.setDescription(newDescription);
        task.setUpdatedAt(LocalDateTime.now());
        repository.update(task);
        System.out.println(ConsoleColors.info("🔄 Task updated successfully."));
    }

    public void deleteTask(UUID id) {
        repository.delete(id);
        System.out.println(ConsoleColors.warning("🗑️ Task " + id + " deleted."));
    }

    public void markTask(UUID id, Status status) {
        Task task = repository.findById(id);
        task.setStatus(status);
        task.setUpdatedAt(LocalDateTime.now());
        repository.update(task);
        System.out.println(ConsoleColors.highlight("📝 Task marked as " + status));
    }

    public List<Task> listAll() {
        return repository.findAll();
    }

    public List<Task> listByStatus(Status status) {
        return repository.findByStatus(status);
    }
}
