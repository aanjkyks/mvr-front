package com.herokuapp.movieratingsystem.frontend.service;

import com.herokuapp.movieratingsystem.frontend.MovieWithFile;
import com.herokuapp.movieratingsystem.frontend.integration.model.MovieDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class MovieMapper {
    public MovieDto toBase64Movie(MovieWithFile input){
        String poster = null;
        try {
            var inputPoster = input.getPoster();
            if (inputPoster != null) {
                poster = Base64.getEncoder().encodeToString(inputPoster.getBytes());
            }
        } catch (IOException ignored) {
        }
        return new MovieDto()
                .setDescription(input.getDescription())
                .setId(input.getId())
                .setPoster(poster)
                .setActors(input.getActors())
                .setDirector(input.getDirector());
    }
}
