package com.herokuapp.movieratingsystem.frontend.service;

import com.herokuapp.movieratingsystem.frontend.integration.BackendConsumer;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final BackendConsumer backendConsumer;

    public MovieService(BackendConsumer backendConsumer) {
        this.backendConsumer = backendConsumer;
    }


}
