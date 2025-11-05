package com.projekt.nartyBackend.mappers;

import com.projekt.nartyBackend.dto.UploadTicketRequest;
import com.projekt.nartyBackend.entities.Karnet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    Karnet toEntity(UploadTicketRequest uploadTicketRequest);
}
