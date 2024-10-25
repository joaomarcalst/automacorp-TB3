package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.WindowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WindowDao extends JpaRepository<WindowEntity, Long>, WindowDaoCustom {

    @Query("select w from WindowEntity w where w.room.name = :roomName")
    List<WindowEntity> findWindowsByRoomName(@Param("roomName") String roomName);

    @Modifying
    @Transactional
    @Query("delete from WindowEntity w where w.room.id = :roomId")
    void deleteByRoom(@Param("roomId") Long roomId);

    @Modifying
    @Transactional
    @Query("update WindowEntity w set w.windowStatus.value = :status where w.room.id = :roomId")
    void updateWindowStatusByRoom(@Param("roomId") Long roomId, @Param("status") Double status);
}