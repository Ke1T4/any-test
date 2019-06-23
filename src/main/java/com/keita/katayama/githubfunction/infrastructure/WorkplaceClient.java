package com.keita.katayama.githubfunction.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class WorkplaceClient {
    private final RestTemplate restTemplate;

    public WorkplaceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendFunction(String url) {
        Object response = new Object();
        restTemplate.postForLocation(URI.create(url),response);
    }

}
