package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.RoomEntity;

import java.util.List;

public interface RoomDaoCustom {
    List<RoomEntity> findRoomsByFloor(Integer floor);
}