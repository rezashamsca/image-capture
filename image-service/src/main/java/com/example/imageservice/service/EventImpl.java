package com.example.imageservice.service;

import com.example.imageservice.api.EventApi;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class EventImpl implements EventApi {
    @Override
    public void imageReceived(UUID imageId, MultipartFile file) {
        // push to Kafka
    }
}
