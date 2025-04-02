package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JsonRepository<T> {
    private final String filename;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonRepository(String filename) {
        this.filename = filename;
    }

    public List<T> load(Class<T> clazz) {
        File file = new File(filename);
        if (!file.exists()) return new ArrayList<>();
        try {
            return objectMapper.readValue(file, new TypeReference<List<T>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void save(List<T> items) {
        try {
            objectMapper.writeValue(new File(filename), items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
