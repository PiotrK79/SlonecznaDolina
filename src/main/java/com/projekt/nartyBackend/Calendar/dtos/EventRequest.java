package com.projekt.nartyBackend.Calendar.dtos;

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
    private String title;
    private String description;
}
