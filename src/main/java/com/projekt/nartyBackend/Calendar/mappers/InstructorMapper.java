package com.projekt.nartyBackend.Calendar.mappers;

import com.projekt.nartyBackend.Calendar.dtos.InstructorRequest;
import com.projekt.nartyBackend.Calendar.entities.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    Instructor toEntity(InstructorRequest request);
}
