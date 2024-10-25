package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorDao extends JpaRepository<SensorEntity, Long>, SensorDaoCustom {

    List<SensorEntity> findBySensorType(String sensorType); // Custom finder by type

    @Query("SELECT s FROM SensorEntity s WHERE s.name = :name")  // Finder by name using @Query
    SensorEntity findByName(@Param("name") String name);

    @Modifying  // Deletion based on sensor name
    @Query("DELETE FROM SensorEntity s WHERE s.name = :name")
    void deleteByName(@Param("name") String name);
}