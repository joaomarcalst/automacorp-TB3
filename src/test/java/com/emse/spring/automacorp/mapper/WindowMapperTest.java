package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.FakeEntityBuilder;
import com.emse.spring.automacorp.dto.Window;
import com.emse.spring.automacorp.model.WindowEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WindowMapperTest {

    @Test
    void shouldMapWindowEntityToDto() {
        WindowEntity entity = FakeEntityBuilder.createWindowEntity(1L, "Window 1", FakeEntityBuilder.createRoomEntity(1L, "Room1"));

        Window window = WindowMapper.toDto(entity);

        Assertions.assertThat(window.id()).isEqualTo(1L);
        Assertions.assertThat(window.name()).isEqualTo("Window 1");
        Assertions.assertThat(window.windowStatus().name()).isEqualTo("Window Status");
        Assertions.assertThat(window.roomId()).isEqualTo(1L);
    }
}