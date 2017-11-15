package com.example.imageservice.api;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageApi {
    Long uploadImage(MultipartFile file);
    Resource getImage(Long imageId);
}
