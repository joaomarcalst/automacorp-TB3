package com.emse.spring.automacorp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SP_ROOM")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RoomEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    private Integer floor;

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Column(nullable = false, length = 255)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "current_temperature_id", nullable = false)
    private SensorEntity currentTemperature;

    public SensorEntity getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(SensorEntity currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    @Column(nullable = false)
    private Double targetTemperature;

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<WindowEntity> windows;

    public List<WindowEntity> getWindows() {
        return windows;
    }

    public void setWindows(List<WindowEntity> windows) {
        this.windows = windows;
    }

    // Constructor with non-nullable fields
    public RoomEntity(Integer floor, String name, SensorEntity currentTemperature, Double targetTemperature) {
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
    }
}
