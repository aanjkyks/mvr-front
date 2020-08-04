package com.herokuapp.movieratingsystem.frontend.service;

import com.herokuapp.movieratingsystem.frontend.integration.model.PersonDto;
import com.herokuapp.movieratingsystem.frontend.model.PersonWithFile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service
public class PersonMapper {
    public PersonDto toBackendPerson(PersonWithFile input) {
        String photo = null;
        try {
            photo = Base64.getEncoder().encodeToString(input.getPhoto().getBytes());
        } catch (IOException ignored) {
        }
        return new PersonDto()
                .setId(input.getId())
                .setName(input.getName())
                .setRole("")
                .setPhoto(photo);
    }
}
