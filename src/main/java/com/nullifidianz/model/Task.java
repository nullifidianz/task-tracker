package com.nullifidianz.model;


import com.nullifidianz.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    private UUID id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task() {
    }

    public Task(UUID id, String description, Status status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-36s | %-29s | %-12s | %-19s | %-19s |",
                id, truncate(description, 29), status,
                createdAt.toString().replace('T', ' '),
                updatedAt.toString().replace('T', ' ')
        );
    }

    private String truncate(String value, int length) {
        if (value == null) return "";
        return value.length() <= length ? value : value.substring(0, length - 3) + "...";
    }


}
