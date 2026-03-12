package com.projekt.nartyBackend.Calendar.dtos;

import com.projekt.nartyBackend.Calendar.entities.Instructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventRequest {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @NotBlank(message = "name is required")
    @Size(max = 255, message = "name must be less than 255 characters")
    private String title;
    @Size(max = 255, message = "description must be less than 255 characters")
    private String description;
    //@NotBlank(message = "instructor cannot be null")
    private Instructor instructor;
}
