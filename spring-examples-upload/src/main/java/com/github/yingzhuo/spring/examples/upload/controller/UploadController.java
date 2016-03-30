package com.github.yingzhuo.spring.examples.upload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class UploadController {

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("files") MultipartFile[] uploadFiles) throws IOException {

        for (MultipartFile uploadFile : uploadFiles) {
            String filename = uploadFile.getOriginalFilename();
            InputStream inputStream = uploadFile.getInputStream();
            byte[] byteArray = uploadFile.getBytes();

            // save the file here
        }

        return "OK";
    }
}
