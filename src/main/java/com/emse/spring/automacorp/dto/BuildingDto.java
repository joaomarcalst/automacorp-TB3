package com.emse.spring.automacorp.dto;

import java.util.List;

public record BuildingDto(Long id, String name, List<Room> rooms) {
}