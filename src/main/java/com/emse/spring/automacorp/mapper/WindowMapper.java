package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Window;
import com.emse.spring.automacorp.model.WindowEntity;

public class WindowMapper {
    public static Window toDto(WindowEntity entity) {
        return new Window(entity.getId(), entity.getName(), SensorMapper.toDto(entity.getWindowStatus()), entity.getRoom().getId());
    }
}