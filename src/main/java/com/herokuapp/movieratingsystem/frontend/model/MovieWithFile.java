package com.herokuapp.movieratingsystem.frontend.model;

import com.herokuapp.movieratingsystem.frontend.integration.model.MovieDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class MovieWithFile {
    private Long id;
    private Double avgRating;
    private Integer totalRatings;
    private String description;
    private String name;
    private MultipartFile poster;
    private Long director;
    private List<Long> actors = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public MovieWithFile setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public MovieWithFile setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
        return this;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public MovieWithFile setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MovieWithFile setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public MovieWithFile setName(String name) {
        this.name = name;
        return this;
    }

    public MultipartFile getPoster() {
        return poster;
    }

    public MovieWithFile setPoster(MultipartFile poster) {
        this.poster = poster;
        return this;
    }

    public Long getDirector() {
        return director;
    }

    public MovieWithFile setDirector(Long director) {
        this.director = director;
        return this;
    }

    public List<Long> getActors() {
        return actors;
    }

    public MovieWithFile setActors(List<Long> actors) {
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
        MovieWithFile that = (MovieWithFile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(avgRating, that.avgRating) &&
                Objects.equals(totalRatings, that.totalRatings) &&
                Objects.equals(description, that.description) &&
                Objects.equals(name, that.name) &&
                Objects.equals(poster, that.poster) &&
                Objects.equals(director, that.director) &&
                Objects.equals(actors, that.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avgRating, totalRatings, description, name, poster, director, actors);
    }
}
