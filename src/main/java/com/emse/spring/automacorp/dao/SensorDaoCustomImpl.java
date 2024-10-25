package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.SensorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class SensorDaoCustomImpl implements SensorDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<SensorEntity> findSensorsByRoomId(Long roomId) {
        String jpql = "SELECT s FROM SensorEntity s JOIN RoomEntity r ON r.currentTemperature.id = s.id WHERE r.id = :roomId";
        TypedQuery<SensorEntity> query = em.createQuery(jpql, SensorEntity.class);
        query.setParameter("roomId", roomId);
        return query.getResultList();
    }
}