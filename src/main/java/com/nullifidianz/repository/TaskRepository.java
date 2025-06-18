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
        if (!file.exists()) return new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) json.append(line);
            return TaskJsonParser.parse(json.toString());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load tasks", e);
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(TaskJsonParser.stringify(tasks));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save tasks", e);
        }
    }

    public void save(Task task) {
        tasks.add(task);
        saveToFile();
    }

    public void update(Task updatedTask) {
        tasks = tasks.stream()
                .map(task -> task.getId().equals(updatedTask.getId()) ? updatedTask : task)
                .collect(Collectors.toList());
        saveToFile();
    }

    public void delete(UUID id) {
        tasks.removeIf(task -> task.getId().equals(id));
        saveToFile();
    }

    public Task findById(UUID id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task ID not found"));
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public List<Task> findByStatus(Status status) {
        return tasks.stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }
}
