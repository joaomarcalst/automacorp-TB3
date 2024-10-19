package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.dao.WindowDao;
import com.emse.spring.automacorp.model.WindowEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/windows")
@Transactional
public class WindowController {

    private final WindowDao windowDao;

    public WindowController(WindowDao windowDao) {
        this.windowDao = windowDao;
    }

    // Retrieve all windows
    @GetMapping
    public ResponseEntity<List<WindowEntity>> getAllWindows() {
        List<WindowEntity> windows = windowDao.findAll();
        return ResponseEntity.ok(windows);
    }

    // Retrieve a window by ID
    @GetMapping("/{id}")
    public ResponseEntity<WindowEntity> getWindowById(@PathVariable Long id) {
        Optional<WindowEntity> window = windowDao.findById(id);
        return window.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Create a new window
    @PostMapping
    public ResponseEntity<WindowEntity> createWindow(@RequestBody WindowEntity windowEntity) {
        WindowEntity createdWindow = windowDao.save(windowEntity);
        return ResponseEntity.ok(createdWindow);
    }

    // Update an existing window
    @PutMapping("/{id}")
    public ResponseEntity<WindowEntity> updateWindow(@PathVariable Long id, @RequestBody WindowEntity windowDetails) {
        Optional<WindowEntity> windowOptional = windowDao.findById(id);
        if (windowOptional.isPresent()) {
            WindowEntity existingWindow = windowOptional.get();
            existingWindow.setName(windowDetails.getName());
            existingWindow.setWindowStatus(windowDetails.getWindowStatus());
            WindowEntity updatedWindow = windowDao.save(existingWindow);
            return ResponseEntity.ok(updatedWindow);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a window by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWindow(@PathVariable Long id) {
        Optional<WindowEntity> window = windowDao.findById(id);
        if (window.isPresent()) {
            windowDao.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}