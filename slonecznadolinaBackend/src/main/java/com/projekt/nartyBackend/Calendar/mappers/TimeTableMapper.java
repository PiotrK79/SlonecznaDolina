package com.projekt.nartyBackend.Calendar.mappers;

import com.projekt.nartyBackend.Calendar.dtos.EmptyTableRequest;
import com.projekt.nartyBackend.Calendar.entities.TimeTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeTableMapper {
    TimeTable toEntity(EmptyTableRequest request);
}
