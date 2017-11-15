package com.example.imageservice.api;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageApi {
    Long saveImage(MultipartFile file);
    Resource findImage(Long imageId);
}
