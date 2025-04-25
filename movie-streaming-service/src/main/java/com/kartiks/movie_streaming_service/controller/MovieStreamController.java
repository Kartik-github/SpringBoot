package com.kartiks.movie_streaming_service.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class MovieStreamController {

    public static final Logger logger = Logger.getLogger(MovieStreamController.class.getName());

    public static final String VIDEO_DIRECTORY = "C:\\Users\\Kartik-PC\\Downloads\\Videos\\";

    @Autowired
    private MovieCatalogService movieCatalogService;

    @GetMapping("/stream/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable("videoPath") String videoPath) throws FileNotFoundException {
        File file = new File(VIDEO_DIRECTORY+ videoPath);
        if(!file.exists()) return ResponseEntity.notFound().build();

        InputStreamResource inputStreamResource= new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("video/mp4"))
        .body(inputStreamResource);
    }

    @GetMapping("/stream/with-id/{movieInfoId}")
    public ResponseEntity<InputStreamResource> streamVideoById(@PathVariable("movieInfoId") Long movieInfoId) throws FileNotFoundException {
        String moviePath=movieCatalogService.getMoviePath(movieInfoId);
        logger.info("Resolved movie path = "+moviePath);
        return streamVideo(moviePath);
    }
    
}
