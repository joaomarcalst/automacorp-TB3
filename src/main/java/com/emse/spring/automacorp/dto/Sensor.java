package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.model.SensorType;

public record Sensor(Long id, String name, SensorType sensorType, Double value) {
}