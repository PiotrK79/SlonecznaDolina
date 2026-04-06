package com.projekt.nartyBackend.Income.services;

import com.projekt.nartyBackend.Income.dto.UploadEquipmentRequest;
import com.projekt.nartyBackend.Income.entities.Equipment;
import com.projekt.nartyBackend.Income.mappers.EquipmentMapper;
import com.projekt.nartyBackend.Income.repositories.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EquipmentService {
    private final EquipmentMapper equipmentMapper;
    private final EquipmentRepository equipmentRepository;

    public Equipment uploadEquipment(UploadEquipmentRequest request){
        var equipment = equipmentMapper.toEntity(request);
        equipmentRepository.save(equipment);
        return equipment;

    }

    public List<Equipment> getAllEquipment(Long id){
        if(id == null) return equipmentRepository.findAll();
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        return equipment.map(List::of).orElse(Collections.emptyList());
    }

    public Equipment updateEquipment(UploadEquipmentRequest updatedRequest, Long id){
        var oldEquipment = equipmentRepository.findById(id).orElse(null);
        if(oldEquipment == null) return null;

        equipmentMapper.update(updatedRequest, oldEquipment);
        return equipmentRepository.save(oldEquipment);
    }

    public boolean deleteEquipment(Long id){
        if(id == null || !equipmentRepository.existsById(id)) return false;

        equipmentRepository.deleteById(id);
        return true;
    }
}
