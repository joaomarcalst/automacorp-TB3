package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.api.dto.ApiGouvAdress;
import com.emse.spring.automacorp.api.dto.ApiGouvFeature;
import com.emse.spring.automacorp.api.dto.ApiGouvResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdressSearchService {

    private final RestTemplate restTemplate;

    // Constructor with dependency injection for RestTemplate
    public AdressSearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to search for addresses by a list of keys
    public List<ApiGouvAdress> searchAdress(List<String> keys) {
        // Building the query parameter from the provided keys
        String params = String.join("+", keys);

        // Constructing the URI with query parameters
        String uri = UriComponentsBuilder
                .fromUriString("https://api-adresse.data.gouv.fr/search")
                .queryParam("q", params)
                .queryParam("limit", 15)
                .build()
                .toUriString();

        // Calling the API and getting the response mapped to ApiGouvResponse
        ApiGouvResponse response = restTemplate.getForObject(uri, ApiGouvResponse.class);

        // Returning a list of address properties from the response features
        return response.features().stream()
                .map(ApiGouvFeature::properties)
                .collect(Collectors.toList());
    }
}