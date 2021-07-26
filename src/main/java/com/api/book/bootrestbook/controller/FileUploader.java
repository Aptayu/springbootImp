package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.helper.FileHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploader {
    
    @Autowired
    FileHelper fileHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        boolean a = false;
        System.out.println(file.getOriginalFilename());

        // can check for the validations here
        // if(file.getContentType().equals("image/jpg")){

        // }

        // file upload..
        try {
            a = fileHelper.uploadFile(file);    
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(a){
            return ResponseEntity.ok("file uploaded successfully");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    
    }
}
