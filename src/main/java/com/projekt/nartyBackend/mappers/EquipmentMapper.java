package com.projekt.nartyBackend.mappers;

import com.projekt.nartyBackend.dto.UploadEquipmentRequest;
import com.projekt.nartyBackend.entities.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    Equipment toEntity(UploadEquipmentRequest uploadEquipmentRequest);
}
