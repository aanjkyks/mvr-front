package com.herokuapp.movieratingsystem.frontend.integration;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

public class AbstractConsumer {

    private final WebClient webClient;

    public AbstractConsumer(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    protected <R> R getRequest(URI uri, Class<R> responseClass) {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(responseClass)
                .block();
    }

    protected <T, R> R postRequest(URI uri, T body, Class<R> responseClass) {
        return webClient.post()
                .uri(uri)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(responseClass)
                .block();
    }

    protected <T,R> R putRequest(URI uri, T body, Class<R> responseClass){
        return webClient.put()
                .uri(uri)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(responseClass)
                .block();
    }
}
