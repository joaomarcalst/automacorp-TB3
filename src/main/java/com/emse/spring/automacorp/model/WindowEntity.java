package com.emse.spring.automacorp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SP_WINDOW")
public class WindowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "window_seq")
    @SequenceGenerator(name = "window_seq", sequenceName = "sp_window_seq", allocationSize = 50)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @OneToOne
    @JoinColumn(name = "window_status_id", nullable = false)
    private SensorEntity windowStatus;

    public WindowEntity() {
    }

    public WindowEntity(String name, SensorEntity sensor) {
        this.windowStatus = sensor;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorEntity getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(SensorEntity windowStatus) {
        this.windowStatus = windowStatus;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    public WindowEntity(String name, SensorEntity windowStatus, RoomEntity room) {
        this.name = name;
        this.windowStatus = windowStatus;
        this.room = room;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}