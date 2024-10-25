package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.RoomEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindRoomsByName() {
        // Add test data if needed
        List<RoomEntity> rooms = roomDao.findRoomsByName("Room1");
        Assertions.assertThat(rooms).hasSize(1); // Check the size according to your data
    }

    @Test
    public void shouldUpdateRoomTargetTemperature() {
        // Add test data if needed
        roomDao.updateRoomTargetTemperature(-10L, 25.0);
        RoomEntity room = roomDao.findById(-10L).orElse(null);
        Assertions.assertThat(room).isNotNull();
        Assertions.assertThat(room.getTargetTemperature()).isEqualTo(25.0); // Check if the target temperature is updated
    }

    @Test
    public void shouldFindRoomsByFloor() {
        // Add test data if needed
        List<RoomEntity> rooms = roomDao.findRoomsByFloor(1);
        Assertions.assertThat(rooms).hasSize(2); // Adjust according to your data
    }

}