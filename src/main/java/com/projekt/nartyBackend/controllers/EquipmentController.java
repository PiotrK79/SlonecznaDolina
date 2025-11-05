package com.projekt.nartyBackend.controllers;

import com.projekt.nartyBackend.dto.UploadEquipmentRequest;
import com.projekt.nartyBackend.entities.Equipment;
import com.projekt.nartyBackend.mappers.EquipmentMapper;
import com.projekt.nartyBackend.repositories.EquipmentRepository;
import com.projekt.nartyBackend.services.EquipmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
}
