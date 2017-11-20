package com.example.imageservice.api;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public interface EventApi {
    void imageReceived(UUID imageId, MultipartFile file);
}
