package com.tp.wrc.findmyparadise.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:8081")
public class FileUploader {

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        return String.format("File %s uploaded successfully", multipartFile.getOriginalFilename());
    }


}