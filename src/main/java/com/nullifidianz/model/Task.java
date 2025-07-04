package com.nullifidianz.model;

import com.nullifidianz.enums.Status;
import com.nullifidianz.utils.ConsoleColors;

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
        String createdAtStr = createdAt != null
                ? createdAt.toString().substring(0, Math.min(19, createdAt.toString().length()))
                : "N/A";
        String updatedAtStr = updatedAt != null
                ? updatedAt.toString().substring(0, Math.min(19, updatedAt.toString().length()))
                : "N/A";

        String statusColor = switch (status) {
            case TODO -> ConsoleColors.YELLOW_BOLD;
            case IN_PROGRESS -> ConsoleColors.BLUE_BOLD;
            case COMPLETED -> ConsoleColors.GREEN_BOLD;
        };

        return String.format(
                "| %-36s | %-29s | %-12s | %-19s | %-19s |",
                ConsoleColors.WHITE_BRIGHT + id.toString() + ConsoleColors.RESET,
                truncate(description, 29),
                statusColor + status.name() + ConsoleColors.RESET,
                createdAtStr,
                updatedAtStr);
    }

    private String truncate(String text, int maxLength) {
        if (text.length() <= maxLength)
            return text;
        return text.substring(0, maxLength - 3) + "...";
    }

}
