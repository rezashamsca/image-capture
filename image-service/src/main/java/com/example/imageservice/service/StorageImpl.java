package com.example.imageservice.service;

import com.example.imageservice.api.StorageApi;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StorageImpl implements StorageApi {

    @Override
    public Resource findImage(UUID imageId) {
        return null;
    }
}
