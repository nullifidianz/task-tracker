package com.nullifidianz.repository;

import com.nullifidianz.enums.Status;
import com.nullifidianz.model.Task;
import com.nullifidianz.utils.TaskJsonParser;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TaskRepository {
    private static final String FILE_NAME = "tasks.json";
    private List<Task> tasks;

    public TaskRepository() {
        this.tasks = loadTasks();
    }

    private List<Task> loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0)
            return new ArrayList<>();
        try {
            String json = java.nio.file.Files.readString(file.toPath());
            return TaskJsonParser.parse(json);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load tasks", e);
        }
    }

    private void saveToFile() {
        try {
            java.nio.file.Files.writeString(new File(FILE_NAME).toPath(), TaskJsonParser.stringify(tasks));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save tasks", e);
        }
    }

    public void save(Task task) {
        this.tasks = loadTasks();
        tasks.add(task);
        saveToFile();
    }

    public void update(Task updatedTask) {
        this.tasks = loadTasks();
        tasks = tasks.stream()
                .map(task -> task.getId().equals(updatedTask.getId()) ? updatedTask : task)
                .collect(Collectors.toList());
        saveToFile();
    }

    public void delete(UUID id) {
        this.tasks = loadTasks();
        tasks.removeIf(task -> task.getId().equals(id));
        saveToFile();
    }

    public Task findById(UUID id) {
        this.tasks = loadTasks();
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task ID not found"));
    }

    public List<Task> findAll() {
        this.tasks = loadTasks();
        return new ArrayList<>(tasks);
    }

    public List<Task> findByStatus(Status status) {
        this.tasks = loadTasks();
        return tasks.stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }
}
