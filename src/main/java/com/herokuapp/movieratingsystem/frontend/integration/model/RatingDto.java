package com.herokuapp.movieratingsystem.frontend.integration.model;

import java.util.Objects;
import java.util.StringJoiner;

public class RatingDto {
    private Long movie;
    private Integer value;

    public Long getMovie() {
        return movie;
    }

    public RatingDto setMovie(Long movie) {
        this.movie = movie;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public RatingDto setValue(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RatingDto.class.getSimpleName() + "[", "]")
                .add("movie=" + movie)
                .add("value=" + value)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingDto ratingDto = (RatingDto) o;
        return Objects.equals(movie, ratingDto.movie) &&
                Objects.equals(value, ratingDto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, value);
    }
}
