package com.kartiks.movie_catalog_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kartiks.movie_catalog_service.model.MovieInfo;
import com.kartiks.movie_catalog_service.model.MovieInfoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class MovieInfoController {
    
@Autowired
private MovieInfoRepository repository;

    @PostMapping("/movie-info/save")
    public List<MovieInfo> saveAll(@RequestBody List<MovieInfo> infos) {
        
        return repository.saveAll(infos);
    }

    @GetMapping("/movie-info/list")
    public List<MovieInfo> getAllInfos() {
        return repository.findAll();
    }

    @GetMapping("/movie-info/hello")
    public String hello() {
        return "Nickelodeon";
    }

    @GetMapping("/movie-info/find-path-by-id/{movieInfoId}")
    public String findPathByIdString(@PathVariable("movieInfoId") Long movieInfoId) {
        var videoInfoOptional = repository.findById(movieInfoId);
        return videoInfoOptional.map(MovieInfo::getPath).orElse(null);
    }
    
    
    
}
