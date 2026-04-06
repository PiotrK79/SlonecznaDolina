package com.projekt.nartyBackend.Income.controllers;

import com.projekt.nartyBackend.Calendar.entities.Event;
import com.projekt.nartyBackend.Income.dto.UploadEquipmentRequest;
import com.projekt.nartyBackend.Income.entities.Equipment;
import com.projekt.nartyBackend.Income.services.EquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@AllArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<Equipment> uploadEquipment(@RequestBody UploadEquipmentRequest request,
                                          UriComponentsBuilder uriBuilder) {
        var eq = equipmentService.uploadEquipment(request);
        var uri = uriBuilder.path("/equipment/{id}").buildAndExpand(eq.getId()).toUri();
        return ResponseEntity.created(uri).body(eq);
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getEquipment(@RequestParam(required = false) Long id) {
        List<Equipment> equipment = equipmentService.getAllEquipment(id);
        if(equipment.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(equipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEquipment(@RequestBody  UploadEquipmentRequest request,
                                             @PathVariable Long id) {

        var eq = equipmentService.updateEquipment(request, id);
        if(eq==null) return ResponseEntity.notFound().build();

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        var eq = equipmentService.deleteEquipment(id);
        if(!eq)  return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
