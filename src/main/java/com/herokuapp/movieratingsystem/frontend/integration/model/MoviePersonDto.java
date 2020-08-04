package com.herokuapp.movieratingsystem.frontend.integration.model;

import java.util.Objects;
import java.util.StringJoiner;

public class MoviePersonDto {
    private Long movie;
    private String movieName;
    private String role;
    private String poster;

    public Long getMovie() {
        return movie;
    }

    public MoviePersonDto setMovie(Long movie) {
        this.movie = movie;
        return this;
    }

    public String getMovieName() {
        return movieName;
    }

    public MoviePersonDto setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    public String getRole() {
        return role;
    }

    public MoviePersonDto setRole(String role) {
        this.role = role;
        return this;
    }

    public String getPoster() {
        return poster;
    }

    public MoviePersonDto setPoster(String poster) {
        this.poster = poster;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MoviePersonDto.class.getSimpleName() + "[", "]")
                .add("movie=" + movie)
                .add("movieName='" + movieName + "'")
                .add("role='" + role + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviePersonDto that = (MoviePersonDto) o;
        return Objects.equals(movie, that.movie) &&
                Objects.equals(movieName, that.movieName) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, movieName, role);
    }
}
