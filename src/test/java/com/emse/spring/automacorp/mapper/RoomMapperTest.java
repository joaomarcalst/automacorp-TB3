package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.FakeEntityBuilder;
import com.emse.spring.automacorp.dto.Room;
import com.emse.spring.automacorp.model.RoomEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RoomMapperTest {

    @Test
    void shouldMapRoomEntityToDto() {
        RoomEntity entity = FakeEntityBuilder.createRoomEntity(1L, "Room1");

        Room room = RoomMapper.toDto(entity);

        Assertions.assertThat(room.id()).isEqualTo(1L);
        Assertions.assertThat(room.name()).isEqualTo("Room1");
        Assertions.assertThat(room.windows()).hasSize(2);
    }
}