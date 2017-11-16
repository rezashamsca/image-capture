package com.example.imageservice.api;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageApi {
    Long uploadImage(MultipartFile file);
    Resource getImage(Long imageId);
}
