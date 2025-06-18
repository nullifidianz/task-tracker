package com.nullifidianz.utils;

import com.nullifidianz.model.Task;

import java.util.List;

public class TaskPrinter {

    public static void print(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println(ConsoleColors.warning("No tasks found."));
            return;
        }

        printHeader();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void printHeader() {
        String header = ConsoleColors.title("TASK TRACKER - Lista de Tarefas");
        System.out.println("\n" + header);
        System.out.println(ConsoleColors.CYAN + "=".repeat(header.length()) + ConsoleColors.RESET);

        String tableHeader = String.format(
                "| %-36s | %-29s | %-12s | %-19s | %-19s |",
                "ID", "Description", "Status", "Created At", "Updated At");
        System.out.println(ConsoleColors.BLUE_BOLD + tableHeader + ConsoleColors.RESET);

        String separator = "|" + "-".repeat(36) + "|" + "-".repeat(29) + "|" +
                "-".repeat(12) + "|" + "-".repeat(19) + "|" + "-".repeat(19) + "|";
        System.out.println(ConsoleColors.CYAN + separator + ConsoleColors.RESET);
    }
}
