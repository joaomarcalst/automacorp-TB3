package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.RoomEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<RoomEntity> findRoomsByFloor(Integer floor) {
        String jpql = "select r from RoomEntity r where r.floor = :floor";
        return em.createQuery(jpql, RoomEntity.class)
                .setParameter("floor", floor)
                .getResultList();
    }
}