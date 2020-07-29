package com.herokuapp.movieratingsystem.frontend.integration;

import com.herokuapp.movieratingsystem.frontend.integration.model.MovieDto;
import com.herokuapp.movieratingsystem.frontend.integration.model.MoviePersonInfoDto;
import com.herokuapp.movieratingsystem.frontend.integration.model.PersonDto;
import com.herokuapp.movieratingsystem.frontend.integration.model.RatingDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class BackendConsumer extends AbstractConsumer {
    private final String backendUrl;


    public BackendConsumer(@Value("mvr.backend.url") String backendUrl, WebClient.Builder builder) {
        super(builder);
        this.backendUrl = backendUrl;
    }

    public MoviePersonInfoDto getActorById(long id) {
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/person")
                .pathSegment(String.valueOf(id))
                .build()
                .toUri();

        return getRequest(uri, MoviePersonInfoDto.class);
    }

    public List<MovieDto> findMovies(String name, String directorName){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/movies")
                .queryParam("name", name)
                .queryParam("dName", directorName)
                .build()
                .toUri();

        return getRequest(uri, List.class);
    }

    public MovieDto findMovieById(long id){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/movies")
                .pathSegment(String.valueOf(id))
                .build()
                .toUri();

        return getRequest(uri, MovieDto.class);
    }

    public MovieDto createMovie(MovieDto request){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/movies")
                .build()
                .toUri();

        return postRequest(uri, request, MovieDto.class);
    }

    public MovieDto updateMovie(MovieDto request){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/movies")
                .build()
                .toUri();

        return putRequest(uri, request, MovieDto.class);
    }

    public PersonDto createPerson(PersonDto request){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/people")
                .build()
                .toUri();

        return postRequest(uri, request, PersonDto.class);
    }

    public PersonDto updatePerson(PersonDto request){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/people")
                .build()
                .toUri();

        return putRequest(uri, request, PersonDto.class);
    }

    public List<PersonDto> findPeople(String name){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/people")
                .queryParam("name", name)
                .build()
                .toUri();

        return getRequest(uri, List.class);
    }

    public PersonDto findPersonById(Long id){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/people")
                .pathSegment(String.valueOf(id))
                .build()
                .toUri();

        return getRequest(uri, PersonDto.class);
    }

    public RatingDto createRating(RatingDto request){
        var uri = UriComponentsBuilder.fromUriString(backendUrl)
                .pathSegment("api/ratings")
                .build()
                .toUri();

        return postRequest(uri, request, RatingDto.class);
    }
}

