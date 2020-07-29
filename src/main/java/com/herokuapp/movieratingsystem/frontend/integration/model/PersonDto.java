package com.herokuapp.movieratingsystem.frontend.integration.model;

import java.util.Objects;
import java.util.StringJoiner;

public class PersonDto {
    private Long id;
    private String name;
    private String photo;
    private String role;

    public Long getId() {
        return id;
    }

    public PersonDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public PersonDto setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getRole() {
        return role;
    }

    public PersonDto setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("photo='" + photo + "'")
                .add("role='" + role + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(id, personDto.id) &&
                Objects.equals(name, personDto.name) &&
                Objects.equals(photo, personDto.photo) &&
                Objects.equals(role, personDto.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, photo, role);
    }
}
