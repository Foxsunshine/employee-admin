package com.example.demo.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {

    @Autowired
    ImageService imageService;

    public void updateAllEmployeeImages(String imagePath, int num) {
        for (int i = 1; i <= num; i++) {
            try {
                imageService.updateImage(imagePath, i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
