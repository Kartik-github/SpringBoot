package com.kartiks.movie_catalog_service.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieInfoRepository extends JpaRepository<MovieInfo,Long>{
    
}
