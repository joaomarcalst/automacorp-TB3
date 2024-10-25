package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Sensor;
import com.emse.spring.automacorp.model.SensorEntity;

public class SensorMapper {
    public static Sensor toDto(SensorEntity entity) {
        return new Sensor(entity.getId(), entity.getName(), entity.getSensorType(), entity.getValue());
    }
}