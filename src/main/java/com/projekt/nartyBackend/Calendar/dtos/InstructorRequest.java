package com.projekt.nartyBackend.Calendar.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class InstructorRequest {

    @NotBlank(message = "name is required")
    @Size(max = 255, message = "name must be less than 255 characters")
    private String firstName;

    @Size(max = 255, message = "name must be less than 255 characters")
    private String lastName;
}
