package com.projekt.nartyBackend.Income.controllers;

import com.projekt.nartyBackend.Calendar.dtos.EventRequest;
import com.projekt.nartyBackend.Calendar.entities.Event;
import com.projekt.nartyBackend.Income.dto.UploadEquipmentRequest;
import com.projekt.nartyBackend.Income.entities.Equipment;
import com.projekt.nartyBackend.Income.mappers.EquipmentMapper;
import com.projekt.nartyBackend.Income.repositories.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipment")
@AllArgsConstructor
public class EquipmentController {
    private final EquipmentMapper equipmentMapper;
    private final EquipmentRepository equipmentRepository;

    @PostMapping
    public ResponseEntity<Equipment> uploadEquipment(@RequestBody UploadEquipmentRequest request,
                                          UriComponentsBuilder uriBuilder) {
        var eq = equipmentMapper.toEntity(request);
        equipmentRepository.save(eq);
        var uri = uriBuilder.path("/equipment/{id}").buildAndExpand(eq.getId()).toUri();
        return ResponseEntity.created(uri).body(eq);
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getEquipments(@RequestParam(required = false) Long id) {
        List<Equipment> equipment;
        if(id == null) {
            equipment = equipmentRepository.findAll();
        }else{
            Optional<Equipment> eq = equipmentRepository.findById(id);

            if(eq.isPresent()) {
                equipment = List.of(eq.get());
            }else {
                equipment = Collections.emptyList();
            }

        }
        return ResponseEntity.ok(equipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@RequestBody  UploadEquipmentRequest request,
                                             @PathVariable Long id,
                                             UriComponentsBuilder uriBulder) {
        var eq = equipmentRepository.findById(id).orElse(null);
        System.out.println(request.getPrice()+" " + request.getName()+"  "+id);
        System.out.println(eq.toString());
        if(eq!=null) {
            System.out.println("NN");
            equipmentMapper.update(request,eq);
            equipmentRepository.save(eq);
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        var evO = equipmentRepository.findById(id).orElse(null);
        if(evO==null) {
            return ResponseEntity.notFound().build();
        }
        equipmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
