package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Sensor;
import com.emse.spring.automacorp.model.SensorEntity;
import com.emse.spring.automacorp.model.SensorType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SensorMapperTest {

    @Test
    void shouldMapSensorEntityToDto() {
        SensorEntity entity = new SensorEntity(SensorType.TEMPERATURE, "Room Temp");
        entity.setId(1L);
        entity.setValue(23.0);

        Sensor sensor = SensorMapper.toDto(entity);

        Assertions.assertThat(sensor.id()).isEqualTo(1L);
        Assertions.assertThat(sensor.name()).isEqualTo("Room Temp");
        Assertions.assertThat(sensor.sensorType()).isEqualTo(SensorType.TEMPERATURE);
        Assertions.assertThat(sensor.value()).isEqualTo(23.0);
    }
}