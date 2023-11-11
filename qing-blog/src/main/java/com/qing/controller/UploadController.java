package com.qing.controller;


import com.qing.entity.ResponseResult;
import com.qing.service.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
public class UploadController {

    @Resource
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseResult upload(MultipartFile img) throws Exception {
        return uploadService.uploadOss(img);
    }


}
