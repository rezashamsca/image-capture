package com.example.imageservice.service;

import com.example.imageservice.api.StorageApi;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageImpl implements StorageApi {

    @Override
    public Long saveImage(MultipartFile file) {
        return null;
    }

    @Override
    public Resource findImage(Long imageId) {
        return null;
    }
}
