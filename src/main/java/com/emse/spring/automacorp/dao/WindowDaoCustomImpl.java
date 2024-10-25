package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.WindowEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WindowDaoCustomImpl implements WindowDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<WindowEntity> findRoomsWithOpenWindows(Long roomId) {
        String jpql = "select w from WindowEntity w " +
                "join w.windowStatus s " +
                "where w.room.id = :roomId and s.value > 0.0";
        return em.createQuery(jpql, WindowEntity.class)
                .setParameter("roomId", roomId)
                .getResultList();
    }
    @Override
    public void deleteByRoom(Long roomId) {
        String jpql = "delete from WindowEntity w where w.room.id = :roomId";
        em.createQuery(jpql)
                .setParameter("roomId", roomId)
                .executeUpdate();
    }
}