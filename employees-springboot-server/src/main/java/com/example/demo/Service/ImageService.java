package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // For inserting image from a file
    public void insertImage(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] imageBytes = Files.readAllBytes(path);
        jdbcTemplate.update("INSERT INTO employees (image) VALUES (?)", imageBytes);
    }

    // For inserting image from MultipartFile
    public void insertImage(MultipartFile file) throws IOException {
        byte[] imageBytes = file.getBytes();
        jdbcTemplate.update("INSERT INTO employees (image) VALUES (?)", imageBytes);
    }

    public void deleteImage(int id) {
        jdbcTemplate.update("DELETE FROM employees WHERE id = ?", id);
    }

    // For updating image from a file
    public void updateImage(String filePath, int id) throws IOException {
        Path path = Paths.get(filePath);
        byte[] imageBytes = Files.readAllBytes(path);
        jdbcTemplate.update("UPDATE employees SET image = ? WHERE id = ?", imageBytes, id);
    }

    // For updating image from MultipartFile
    public void updateImage(MultipartFile file, int id) throws IOException {
        byte[] imageBytes = file.getBytes();
        jdbcTemplate.update("UPDATE employees SET image = ? WHERE id = ?", imageBytes, id);
    }
}
