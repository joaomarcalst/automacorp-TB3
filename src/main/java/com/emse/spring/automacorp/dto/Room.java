package com.emse.spring.automacorp.dto;

import java.util.List;

public record Room(Long id, String name, Integer floor, Double targetTemperature, Sensor currentTemperature, List<Window> windows) {
}