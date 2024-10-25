package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Room;
import com.emse.spring.automacorp.dto.Window;
import com.emse.spring.automacorp.model.RoomEntity;

import java.util.List;
import java.util.stream.Collectors;

public class RoomMapper {
    public static Room toDto(RoomEntity entity) {
        List<Window> windows = entity.getWindows()
                .stream()
                .map(WindowMapper::toDto)
                .collect(Collectors.toList());
        return new Room(
                        entity.getId(),
                        entity.getName(),
                        entity.getFloor(),
                entity.getTargetTemperature(),
                SensorMapper.toDto(entity.getCurrentTemperature()),
                        windows
                );
    }
}