package com.projekt.nartyBackend.Income.mappers;

import com.projekt.nartyBackend.Income.dto.UploadEquipmentRequest;
import com.projekt.nartyBackend.Income.entities.Equipment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-12T23:18:23+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class EquipmentMapperImpl implements EquipmentMapper {

    @Override
    public Equipment toEntity(UploadEquipmentRequest uploadEquipmentRequest) {
        if ( uploadEquipmentRequest == null ) {
            return null;
        }

        Equipment equipment = new Equipment();

        equipment.setName( uploadEquipmentRequest.getName() );
        equipment.setPrice( uploadEquipmentRequest.getPrice() );

        return equipment;
    }

    @Override
    public void update(UploadEquipmentRequest uploadEquipmentRequest, Equipment equipment) {
        if ( uploadEquipmentRequest == null ) {
            return;
        }

        equipment.setName( uploadEquipmentRequest.getName() );
        equipment.setPrice( uploadEquipmentRequest.getPrice() );
    }
}
