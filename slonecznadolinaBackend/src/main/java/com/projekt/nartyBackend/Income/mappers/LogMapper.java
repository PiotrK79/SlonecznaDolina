package com.projekt.nartyBackend.Income.mappers;

import com.projekt.nartyBackend.Income.dto.UploadLogRequest;
import com.projekt.nartyBackend.Income.entities.Log;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogMapper {
    Log toEntity(UploadLogRequest uploadLogRequest);
}
