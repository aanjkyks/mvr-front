package com.herokuapp.movieratingsystem.frontend.service;

import com.herokuapp.movieratingsystem.frontend.model.MovieWithFile;
import com.herokuapp.movieratingsystem.frontend.integration.BackendConsumer;
import com.herokuapp.movieratingsystem.frontend.integration.model.MovieDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonToMovieBindingService {

    private final MovieMapper movieMapper;
    private final BackendConsumer consumer;

    public PersonToMovieBindingService(MovieMapper movieMapper, BackendConsumer consumer) {
        this.movieMapper = movieMapper;
        this.consumer = consumer;
    }

    public MovieDto resolvePeople(MovieWithFile input){
        var movie = movieMapper.toBase64Movie(input);
        var actors = input.getActors().stream()
                .map(consumer::findPersonById)
                .map(it -> it.setRole(""))
                .collect(Collectors.toList());
        movie.setActors(actors);
        movie.setDirector(consumer.findPersonById(input.getDirector())
                .setRole("Director"));
        return movie;
    }

}
