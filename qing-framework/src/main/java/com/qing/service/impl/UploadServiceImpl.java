package com.qing.service.impl;

import com.qing.entity.ResponseResult;
import com.qing.service.UploadService;
import com.qing.utils.AliyunOSSUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private AliyunOSSUtils aliyunOSSUtils;

    @Override
    public ResponseResult uploadOss(MultipartFile img) throws Exception{

        String filename = img.getOriginalFilename();
        filename = UUID.randomUUID().toString().replaceAll("-","") + filename;

        String contentType = img.getContentType();

        byte[] content = img.getBytes();

        int hours = 1000;

        String url = aliyunOSSUtils.uploadImage(filename, content, contentType, hours);

        return ResponseResult.okResult(url);
    }
}
