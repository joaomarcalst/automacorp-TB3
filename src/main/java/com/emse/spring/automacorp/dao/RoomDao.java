package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomDao extends JpaRepository<RoomEntity, Long>, RoomDaoCustom {

    @Query("select r from RoomEntity r where r.name = :roomName")
    List<RoomEntity> findRoomsByName(@Param("roomName") String roomName);

    @Modifying
    @Transactional
    @Query("delete from RoomEntity r where r.id = :roomId")
    void deleteByRoomId(@Param("roomId") Long roomId);

    @Modifying
    @Transactional
    @Query("update RoomEntity r set r.targetTemperature = :temperature where r.id = :roomId")
    void updateRoomTargetTemperature(@Param("roomId") Long roomId, @Param("temperature") Double temperature);
}