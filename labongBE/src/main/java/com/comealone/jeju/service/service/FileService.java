package com.comealone.jeju.service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class FileService {
    @Value("${file.path.upload-files}") String defaultPath;
    public String upload(MultipartFile file, String dir){
        try {
            String saveFileName=null;
            if (!file.isEmpty()) {
                String saveFolder = defaultPath + dir;
                File folder = new File(saveFolder);
                if (!folder.exists())
                    folder.mkdirs();
                String originalFileName = file.getOriginalFilename();
                if (!originalFileName.isEmpty()) {
                    saveFileName = UUID.randomUUID().toString()
                            + originalFileName.substring(originalFileName.lastIndexOf('.'));
                    file.transferTo(new File(folder, saveFileName));
                }
            }
            return dir+"/"+saveFileName;
        } catch (Exception e) {
            return null;
        }
    }
}
