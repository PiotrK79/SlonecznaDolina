package com.projekt.nartyBackend.dto;

import com.projekt.nartyBackend.entities.type;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
public class UploadLogRequest {
    private int quantity;
    private type logType;

}
