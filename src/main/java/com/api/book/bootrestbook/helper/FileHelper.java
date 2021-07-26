package com.api.book.bootrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {
    public final String UPLOAD_DIR="E:\\SpringBoot\\BOOT\\bootrestbook\\src\\main\\resources\\static";

    public boolean uploadFile(MultipartFile file){
        boolean f = false;
        try {
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator+ file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return f;
    }

}
