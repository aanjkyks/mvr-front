package com.herokuapp.movieratingsystem.frontend.integration.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class MoviePersonInfoDto {
    private Long id;
    private String name;
    private String photo;
    private List<MoviePersonDto> movies;

    public Long getId() {
        return id;
    }

    public MoviePersonInfoDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MoviePersonInfoDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public MoviePersonInfoDto setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public List<MoviePersonDto> getMovies() {
        return movies;
    }

    public MoviePersonInfoDto setMovies(List<MoviePersonDto> movies) {
        this.movies = movies;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MoviePersonInfoDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("photo='" + photo + "'")
                .add("movies=" + movies)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviePersonInfoDto that = (MoviePersonInfoDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(movies, that.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, photo, movies);
    }
}
