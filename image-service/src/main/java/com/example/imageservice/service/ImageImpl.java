package com.example.imageservice.service;

import com.example.imageservice.api.ImageApi;
import com.example.imageservice.api.EventApi;
import com.example.imageservice.api.StorageApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class ImageImpl implements ImageApi {
    @Autowired
    private EventApi eventApi;

    @Autowired
    private StorageApi storageApi;

    @Override
    public UUID uploadImage(MultipartFile file) {
        UUID imageId = UUID.randomUUID();
        eventApi.imageReceived(imageId, file);
        return imageId;
    }

    @Override
    public Resource getImage(UUID imageId) {
        return storageApi.findImage(imageId);
    }
}
