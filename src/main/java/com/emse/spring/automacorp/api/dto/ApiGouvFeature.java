package com.emse.spring.automacorp.api.dto;

import com.emse.spring.automacorp.api.dto.ApiGouvAdress;

public record ApiGouvFeature(
        String type,
        ApiGouvAdress properties
) {
}