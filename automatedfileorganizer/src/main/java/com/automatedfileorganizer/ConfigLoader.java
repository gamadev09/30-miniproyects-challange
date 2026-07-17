package com.automatedfileorganizer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigLoader {

    public Map<String, List<String>> loadCategories() {

        ObjectMapper mapper = new ObjectMapper();

        File file = new File("config/categories.json");

        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());

        try {
            return mapper.readValue(
                file,
                new TypeReference<Map<String, List<String>>>() {}
            );

        } catch (IOException e) {
            System.out.println("Cannot load categories file.");
            e.printStackTrace(); // <-- Very useful while debugging
        }

        return Map.of();
    }
}