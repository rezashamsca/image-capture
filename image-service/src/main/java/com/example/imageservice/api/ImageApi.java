package com.example.imageservice.api;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public interface ImageApi {
    UUID uploadImage(MultipartFile file);
    Resource getImage(UUID imageId);
}
