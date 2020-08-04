package com.herokuapp.movieratingsystem.frontend.service;

import com.herokuapp.movieratingsystem.frontend.integration.model.RatingDto;
import org.springframework.stereotype.Service;

@Service
public class RatingCreator {
    public RatingDto createRating(Long movieId, Integer rating){
        return new RatingDto()
                .setMovie(movieId)
                .setValue(rating);
    }
}
