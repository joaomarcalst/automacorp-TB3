package com.emse.spring.automacorp;

import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.SensorEntity;
import com.emse.spring.automacorp.model.SensorType;
import com.emse.spring.automacorp.model.WindowEntity;

import java.util.Set;

public class FakeEntityBuilder {

    public static RoomEntity createRoomEntity(Long id, String name) {
        RoomEntity room = new RoomEntity(
                1,
                name,
                createSensorEntity(1L, "Room Temp", SensorType.TEMPERATURE, 23.0),
                24.0);
        room.setId(id);
        room.setWindows((java.util.List<WindowEntity>) Set.of(
                createWindowEntity(id * 10 + 1, "Window 1", room),
                createWindowEntity(id * 10 + 2, "Window 2", room)
        ));
        return room;
    }

    public static WindowEntity createWindowEntity(Long id, String name, RoomEntity room) {
        WindowEntity window = new WindowEntity(name, createSensorEntity(id, "Window Status", SensorType.STATUS, 0.0), room);
        window.setId(id);
        return window;
    }

    public static SensorEntity createSensorEntity(Long id, String name, SensorType type, Double value) {
        SensorEntity sensor = new SensorEntity(type, name);
        sensor.setId(id);
        sensor.setValue(value);
        return sensor;
    }
}