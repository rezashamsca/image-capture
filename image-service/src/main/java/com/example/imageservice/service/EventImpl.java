package com.example.imageservice.service;

import com.example.imageservice.api.EventApi;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.UUID;

@Service
public class EventImpl implements EventApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventImpl.class);

    @Override
    public void imageReceived(UUID imageId, MultipartFile file) {
        // push to Kafka
        try {
            final byte[] bytes = file.getBytes();
            LOGGER.debug(String.valueOf(bytes.length));
        }
        catch (IOException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }
}
