package com.example.imageservice.service;

import com.example.imageservice.api.ImageApi;
import com.example.imageservice.api.StorageApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageImpl implements ImageApi {
    @Autowired
    private StorageApi storageApi;

    @Override
    public Long uploadImage(MultipartFile file) {
        Long imageId = storageApi.saveImage(file);
        return imageId;
    }

    @Override
    public Resource getImage(Long imageId) {
        return storageApi.findImage(imageId);
    }
}
