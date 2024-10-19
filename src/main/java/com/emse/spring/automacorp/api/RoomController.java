package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.dao.RoomDao;
import com.emse.spring.automacorp.model.RoomEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;

    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    // Retrieve all rooms
    @GetMapping
    public ResponseEntity<List<RoomEntity>> getAllRooms() {
        List<RoomEntity> rooms = roomDao.findAll();
        return ResponseEntity.ok(rooms);
    }

    // Retrieve a room by ID
    @GetMapping("/{id}")
    public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long id) {
        Optional<RoomEntity> room = roomDao.findById(id);
        return room.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Create a new room
    @PostMapping
    public ResponseEntity<RoomEntity> createRoom(@RequestBody RoomEntity roomEntity) {
        RoomEntity createdRoom = roomDao.save(roomEntity);
        return ResponseEntity.ok(createdRoom);
    }

    // Update an existing room
    @PutMapping("/{id}")
    public ResponseEntity<RoomEntity> updateRoom(@PathVariable Long id, @RequestBody RoomEntity roomDetails) {
        Optional<RoomEntity> roomOptional = roomDao.findById(id);
        if (roomOptional.isPresent()) {
            RoomEntity existingRoom = roomOptional.get();
            existingRoom.setName(roomDetails.getName());
            existingRoom.setFloor(roomDetails.getFloor());
            existingRoom.setCurrentTemperature(roomDetails.getCurrentTemperature());
            existingRoom.setTargetTemperature(roomDetails.getTargetTemperature());
            RoomEntity updatedRoom = roomDao.save(existingRoom);
            return ResponseEntity.ok(updatedRoom);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a room by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        Optional<RoomEntity> room = roomDao.findById(id);
        if (room.isPresent()) {
            roomDao.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}