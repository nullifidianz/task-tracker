package com.nullifidianz;

import com.nullifidianz.enums.Status;
import com.nullifidianz.service.TaskService;
import com.nullifidianz.utils.TaskPrinter;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();

        if (args.length == 0) {
            System.out.println("No command provided");
            return;
        }

        try {
            switch (args[0]) {
                case "add":
                    service.addTask(args[1]);
                    break;
                case "update":
                    service.updateTask(UUID.fromString(args[1]), args[2]);
                    break;
                case "delete":
                    service.deleteTask(UUID.fromString(args[1]));
                    break;
                case "mark-in-progress":
                    service.markTask(UUID.fromString(args[1]), Status.IN_PROGRESS);
                    break;
                case "mark-done":
                    service.markTask(UUID.fromString(args[1]), Status.COMPLETED);
                    break;
                case "list":
                    if (args.length == 1) {
                        TaskPrinter.print(service.listAll());
                    } else {
                        Status status = switch (args[1]) {
                            case "todo" -> Status.TODO;
                            case "in-progress" -> Status.IN_PROGRESS;
                            case "done" -> Status.COMPLETED;
                            default -> throw new IllegalArgumentException("Invalid status");
                        };
                        TaskPrinter.print(service.listByStatus(status));
                    }
                    break;

                default:
                    System.out.println("Invalid command.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
