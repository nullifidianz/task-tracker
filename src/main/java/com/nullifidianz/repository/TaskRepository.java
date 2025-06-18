package com.nullifidianz.repository;

import com.nullifidianz.enums.Status;
import com.nullifidianz.model.Task;
import com.nullifidianz.utils.TaskJsonParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskRepository {

    private static final String FILE_NAME = "tasks.json";

    private synchronized List<Task> loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            String json = Files.readString(file.toPath());
            List<Task> tasks = TaskJsonParser.parse(json);
            return tasks != null ? tasks : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Warning: Failed to load tasks, starting with empty list: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private synchronized void saveTasks(List<Task> tasks) {
        try {
            String json = TaskJsonParser.stringify(tasks);
            Files.writeString(new File(FILE_NAME).toPath(), json);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save tasks", e);
        }
    }

    public void save(Task task) {
        List<Task> tasks = loadTasks();
        tasks.add(task);
        saveTasks(tasks);
    }

    public void update(Task updatedTask) {
        List<Task> tasks = loadTasks();
        boolean found = false;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(updatedTask.getId())) {
                tasks.set(i, updatedTask);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new RuntimeException("Task not found for update");
        }

        saveTasks(tasks);
    }

    public void delete(UUID id) {
        List<Task> tasks = loadTasks();
        List<Task> filteredTasks = tasks.stream()
                .filter(task -> !task.getId().equals(id))
                .collect(Collectors.toList());
        saveTasks(filteredTasks);
    }

    public Task findById(UUID id) {
        List<Task> tasks = loadTasks();
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task ID not found"));
    }

    public List<Task> findAll() {
        return loadTasks();
    }

    public List<Task> findByStatus(Status status) {
        List<Task> tasks = loadTasks();
        return tasks.stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }
}
