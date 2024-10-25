package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.SensorEntity;
import com.emse.spring.automacorp.model.SensorType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
class SensorDaoTest {

    @Autowired
    private SensorDao sensorDao;

    @Test
    public void shouldFindSensorByName() {
        SensorEntity sensor = sensorDao.findByName("Temperature room 2");
        Assertions.assertThat(sensor).isNotNull();
        Assertions.assertThat(sensor.getName()).isEqualTo("Temperature room 2");
    }

    @Test
    public void shouldFindSensorsByRoomId() {
        List<SensorEntity> sensors = sensorDao.findSensorsByRoomId(-10L);
        Assertions.assertThat(sensors).isNotEmpty();
    }
}