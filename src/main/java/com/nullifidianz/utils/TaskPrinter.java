package com.nullifidianz.utils;

import com.nullifidianz.model.Task;

import java.util.List;

public class TaskPrinter {

    public static void print(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        printHeader();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void printHeader() {
        System.out.println("| ID                                 | Description                   | Status       | Created At          | Updated At          |");
        System.out.println("|------------------------------------|-------------------------------|--------------|---------------------|---------------------|");
    }
}
