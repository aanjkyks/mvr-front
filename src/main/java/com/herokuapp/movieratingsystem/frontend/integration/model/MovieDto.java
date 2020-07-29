package com.herokuapp.movieratingsystem.frontend.integration.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class MovieDto {
    private Long id;
    private Double avgRating;
    private Integer totalRatings;
    private String description;
    private String name;
    private String poster;
    private PersonDto director;
    private List<PersonDto> actors;

    public Long getId() {
        return id;
    }

    public MovieDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public MovieDto setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
        return this;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public MovieDto setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MovieDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public MovieDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPoster() {
        return poster;
    }

    public MovieDto setPoster(String poster) {
        this.poster = poster;
        return this;
    }

    public PersonDto getDirector() {
        return director;
    }

    public MovieDto setDirector(PersonDto director) {
        this.director = director;
        return this;
    }

    public List<PersonDto> getActors() {
        return actors;
    }

    public MovieDto setActors(List<PersonDto> actors) {
        this.actors = actors;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MovieDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("avgRating=" + avgRating)
                .add("totalRatings=" + totalRatings)
                .add("description='" + description + "'")
                .add("name='" + name + "'")
                .add("poster='" + poster + "'")
                .add("director=" + director)
                .add("actors=" + actors)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(id, movieDto.id) &&
                Objects.equals(avgRating, movieDto.avgRating) &&
                Objects.equals(totalRatings, movieDto.totalRatings) &&
                Objects.equals(description, movieDto.description) &&
                Objects.equals(name, movieDto.name) &&
                Objects.equals(poster, movieDto.poster) &&
                Objects.equals(director, movieDto.director) &&
                Objects.equals(actors, movieDto.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avgRating, totalRatings, description, name, poster, director, actors);
    }
}
