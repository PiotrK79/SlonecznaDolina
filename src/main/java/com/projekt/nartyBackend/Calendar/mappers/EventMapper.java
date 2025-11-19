package com.projekt.nartyBackend.Calendar.mappers;

import com.projekt.nartyBackend.Calendar.dtos.EventRequest;
import com.projekt.nartyBackend.Calendar.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntity(EventRequest eventRequest);
    void update(EventRequest eventRequest, @MappingTarget Event event);
}
