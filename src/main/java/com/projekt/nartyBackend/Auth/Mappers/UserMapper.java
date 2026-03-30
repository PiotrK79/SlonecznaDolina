package com.projekt.nartyBackend.Auth.Mappers;

import com.projekt.nartyBackend.Auth.Entities.User;
import com.projekt.nartyBackend.Auth.dtos.RegistationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(RegistationDto registationDto);
    RegistationDto toDto(User user);
}
