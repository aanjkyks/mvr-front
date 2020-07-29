package com.herokuapp.movieratingsystem.frontend.service;

import com.herokuapp.movieratingsystem.frontend.integration.BackendConsumer;

public class PeopleService {
    private final BackendConsumer backendConsumer;

    public PeopleService(BackendConsumer backendConsumer) {
        this.backendConsumer = backendConsumer;
    }
}
