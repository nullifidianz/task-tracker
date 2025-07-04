package com.nullifidianz.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nullifidianz.model.Task;

import java.io.IOException;
import java.util.List;

public class TaskJsonParser {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // Registra o módulo para suporte a java.time.LocalDateTime
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static String stringify(List<Task> tasks) {
        try {
            return mapper.writeValueAsString(tasks);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing tasks", e);
        }
    }

    public static List<Task> parse(String json) {
        if (json == null || json.trim().isEmpty()) {
            return List.of();
        }

        try {
            return mapper.readValue(json, new TypeReference<List<Task>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Erro ao desserializar JSON em tasks", e);
        }
    }
}
