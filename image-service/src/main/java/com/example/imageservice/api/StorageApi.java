package com.example.imageservice.api;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface StorageApi {
    Resource findImage(UUID imageId);
}
