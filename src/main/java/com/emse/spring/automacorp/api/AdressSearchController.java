package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.api.dto.ApiGouvAdress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AdressSearchController {

    private final AdressSearchService adressSearchService;

    public AdressSearchController(AdressSearchService adressSearchService) {
        this.adressSearchService = adressSearchService;
    }

    // Define a GET endpoint to search for addresses
    @GetMapping("/api/addresses")
    public List<ApiGouvAdress> searchAdresses(@RequestParam List<String> keys) {
        return adressSearchService.searchAdress(keys);
    }
}