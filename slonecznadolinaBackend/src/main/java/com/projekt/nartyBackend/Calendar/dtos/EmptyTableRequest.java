package com.projekt.nartyBackend.Calendar.dtos;

import com.projekt.nartyBackend.Auth.Entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmptyTableRequest {
    @NotNull
    @NotBlank
    private User user;
    @NotBlank
    private String name;
}
