package com.nullifidianz.utils;

import com.nullifidianz.enums.Status;
import com.nullifidianz.model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskJsonParser {

    public static String stringify(List<Task> tasks) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            sb.append("{")
                    .append("\"id\":\"").append(t.getId()).append("\",")
                    .append("\"description\":\"").append(escape(t.getDescription())).append("\",")
                    .append("\"status\":\"").append(t.getStatus()).append("\",")
                    .append("\"createdAt\":\"").append(t.getCreatedAt()).append("\",")
                    .append("\"updatedAt\":\"").append(t.getUpdatedAt()).append("\"")
                    .append("}");
            if (i < tasks.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<Task> parse(String json) {
        List<Task> tasks = new ArrayList<>();
        if (json == null || json.trim().isEmpty()) return tasks;

        json = json.trim();
        if (json.equals("[]")) return tasks;
        if (!json.startsWith("[") || !json.endsWith("]")) throw new IllegalArgumentException("Invalid JSON array");

        json = json.substring(1, json.length() - 1).trim(); // remove []

        if (json.isEmpty()) return tasks; // proteção extra

        String[] objects = splitObjects(json);

        for (String obj : objects) {
            Task task = new Task();
            obj = obj.trim();
            if (!obj.startsWith("{") || !obj.endsWith("}")) continue; // ignora objetos inválidos

            String[] fields = obj.substring(1, obj.length() - 1)
                    .split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            for (String field : fields) {
                String[] keyValue = field.split(":", 2);
                if (keyValue.length < 2) continue;

                String key = unquote(keyValue[0].trim());
                String value = unquote(keyValue[1].trim());

                switch (key) {
                    case "id" -> task.setId(UUID.fromString(value));
                    case "description" -> task.setDescription(value);
                    case "status" -> task.setStatus(Status.valueOf(value));
                    case "createdAt" -> task.setCreatedAt(LocalDateTime.parse(value));
                    case "updatedAt" -> task.setUpdatedAt(LocalDateTime.parse(value));
                }
            }

            if (task.getId() != null) tasks.add(task); // só adiciona se foi parseado corretamente
        }

        return tasks;
    }


    private static String[] splitObjects(String jsonArrayContent) {
        List<String> objects = new ArrayList<>();
        int bracketLevel = 0;
        StringBuilder current = new StringBuilder();

        for (char c : jsonArrayContent.toCharArray()) {
            if (c == '{') bracketLevel++;
            if (c == '}') bracketLevel--;
            current.append(c);
            if (bracketLevel == 0 && c == '}') {
                objects.add(current.toString().trim());
                current.setLength(0);
            }
        }

        return objects.toArray(new String[0]);
    }

    private static String unquote(String str) {
        return str.replaceAll("^\"|\"$", "").replace("\\\"", "\"");
    }

    private static String escape(String str) {
        return str.replace("\"", "\\\"");
    }
}
