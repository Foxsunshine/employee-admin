package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController

public class ImageController {

    @Autowired
    private EmployeesRespository respository;

    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Resource file = new UrlResource(Paths.get("img", filename).toUri());

            if (file.exists() || file.isReadable()) {
                return ResponseEntity.ok().body(file);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // @PostMapping("/upload")
    // public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile
    // file) {
    // try {
    // // save file to the file system
    // byte[] bytes = file.getBytes();
    // Path path = Paths.get("file.upload-dir" + file.getOriginalFilename());
    // Files.write(path, bytes);

    // return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    // }
    // }

    private static String UPLOAD_DIR = "img/";

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // 生成随机的文件名
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
            String fileName = UUID.randomUUID().toString() + extension;

            // 将文件保存到文件系统中
            Path filePath = Paths.get(UPLOAD_DIR + fileName);
            Files.write(filePath, file.getBytes());

            // 在这里，你可以将文件的路径保存到数据库中。
            // filePath.toString() 将返回文件的路径。
            String fileLocation = fileName;

            // ... 保存 fileLocation 到数据库
            // respository.createEmployeeWithImg(fileLocation);

            return fileLocation;
        } catch (Exception e) {
            // 处理异常
            return "File upload failed: " + e.getMessage();
        }
    }
}
