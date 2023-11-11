package com.qing.service;

import com.qing.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    ResponseResult uploadOss(MultipartFile img) throws Exception;
}
