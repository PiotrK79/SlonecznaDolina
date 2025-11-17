package com.projekt.nartyBackend.Income.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UploadLogRequest {
    private int quantity;
    private long equipment_id;

}
