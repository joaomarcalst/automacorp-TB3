package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.SensorEntity;
import java.util.List;

public interface SensorDaoCustom {
    List<SensorEntity> findSensorsByRoomId(Long roomId);
}