package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.dao.SensorDao;
import com.emse.spring.automacorp.model.SensorEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensors")
@Transactional
public class SensorController {

    private final SensorDao sensorDao;

    public SensorController(SensorDao sensorDao) {
        this.sensorDao = sensorDao;
    }

    // Retrieve the list of all sensors via GET
    @GetMapping
    public List<SensorEntity> getAllSensors() {
        return sensorDao.findAll();
    }

    // Retrieve a specific sensor by ID via GET
    @GetMapping("/{id}")
    public SensorEntity getSensorById(@PathVariable Long id) {
        return sensorDao.findById(id).orElse(null);
    }

    // Create a new sensor via POST
    @PostMapping
    public SensorEntity createSensor(@RequestBody SensorEntity sensorEntity) {
        return sensorDao.save(sensorEntity);
    }

    // Update an existing sensor via PUT
    @PutMapping("/{id}")
    public SensorEntity updateSensor(@PathVariable Long id, @RequestBody SensorEntity sensorDetails) {
        Optional<SensorEntity> sensorOptional = sensorDao.findById(id);
        if (sensorOptional.isPresent()) {
            SensorEntity existingSensor = sensorOptional.get();
            existingSensor.setName(sensorDetails.getName());
            existingSensor.setSensorType(sensorDetails.getSensorType());
            existingSensor.setValue(sensorDetails.getValue());
            return sensorDao.save(existingSensor);
        }
        return null; // Handle not found case as needed
    }

    // Delete a sensor by ID via DELETE
    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable Long id) {
        sensorDao.deleteById(id);
    }
}