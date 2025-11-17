package com.projekt.nartyBackend.Income.mappers;

import com.projekt.nartyBackend.Income.dto.UploadEquipmentRequest;
import com.projekt.nartyBackend.Income.entities.Equipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    Equipment toEntity(UploadEquipmentRequest uploadEquipmentRequest);
}
