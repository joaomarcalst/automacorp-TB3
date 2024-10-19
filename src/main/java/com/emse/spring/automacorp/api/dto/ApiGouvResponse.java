package com.emse.spring.automacorp.api.dto;

import com.emse.spring.automacorp.api.dto.ApiGouvFeature;

import java.util.List;

public record ApiGouvResponse(
        String version,
        String query,
        Integer limit,
        List<ApiGouvFeature> features
) {
}