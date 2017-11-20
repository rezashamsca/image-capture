package com.example.imageservice.controller;

import com.example.imageservice.api.ImageApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

// http://www.mkyong.com/spring-boot/spring-boot-file-upload-example/
// http://www.baeldung.com/spring-mvc-image-media-data
// https://murygin.wordpress.com/2014/10/13/rest-web-service-file-uploads-spring-boot/
// https://stackoverflow.com/questions/21926893/sending-an-image-and-json-data-to-server-using-ajax-post-request
// https://spring.io/guides/gs/uploading-files/

@RestController
@RequestMapping("/image")
public class ImageServiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceController.class);

    @Autowired
    private ImageApi imageApi;

    @PostMapping(value = "/upload")
    public String imageUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        LOGGER.debug("imageUpload called.");
        UUID imageId = imageApi.uploadImage(file);
        redirectAttributes.addFlashAttribute("message",
                new StringBuilder().append("Successfully uploaded ")
                .append(file.getOriginalFilename())
                .append("!")
                .toString()
                );
        return "redirect:/";
    }

    @GetMapping("{imageId")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable UUID imageId) {
        Resource image = imageApi.getImage(imageId);
        String response = new StringBuilder()
                .append("attachment; filename=\"")
                .append(image.getFilename())
                .append("\"")
                .toString();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, response).body(image);
    }
}
