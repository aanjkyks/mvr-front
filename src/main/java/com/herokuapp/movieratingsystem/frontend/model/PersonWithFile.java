package com.herokuapp.movieratingsystem.frontend.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.StringJoiner;

public class PersonWithFile {
    private Long id;
    private String name;
    private String role;
    private MultipartFile photo;

    public Long getId() {
        return id;
    }

    public PersonWithFile setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonWithFile setName(String name) {
        this.name = name;
        return this;
    }

    public String getRole() {
        return role;
    }

    public PersonWithFile setRole(String role) {
        this.role = role;
        return this;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public PersonWithFile setPhoto(MultipartFile photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonWithFile.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("role='" + role + "'")
                .add("poster=" + photo)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithFile that = (PersonWithFile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(role, that.role) &&
                Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, photo);
    }
}
