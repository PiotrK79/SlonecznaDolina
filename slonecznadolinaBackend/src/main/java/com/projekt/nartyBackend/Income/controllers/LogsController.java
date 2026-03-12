package com.projekt.nartyBackend.Income.controllers;

import com.projekt.nartyBackend.Income.dto.UploadLogRequest;
import com.projekt.nartyBackend.Income.entities.Log;
import com.projekt.nartyBackend.Income.mappers.LogMapper;
import com.projekt.nartyBackend.Income.repositories.EquipmentRepository;
import com.projekt.nartyBackend.Income.repositories.LogsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/log")
@AllArgsConstructor
public class LogsController {
    private final LogsRepository logsRepository;
    private final EquipmentRepository equipmentRepository;
    private final LogMapper logMapper;

    @PostMapping
    public ResponseEntity<Log> saveDailyLogs(@RequestBody UploadLogRequest request,
                                             UriComponentsBuilder uriBuilder) {
        var equipment = equipmentRepository.findById(request.getEquipment_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment not found with ID: " + request.getEquipment_id()));


        var log = logMapper.toEntity(request);

        log.setDate(LocalDateTime.now());
        log.setEquipment(equipment);
        log.setTotalPrice((log.getEquipment().getPrice()).multiply(new BigDecimal(log.getQuantity())));

        logsRepository.save(log);

        System.out.println(log);
        var uri = uriBuilder.path("/log/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(null);

    }

    @GetMapping
    public ResponseEntity<List<Log>> getDailylogs(@RequestParam(required = false) Long id) {
        List<Log> logs;
        if(id == null){
            logs = logsRepository.findAll();
        }else {
            Optional<Log> optionalLog = logsRepository.findById(id);

            if(optionalLog.isPresent()){
                logs = List.of(optionalLog.get());
            }else {
                logs = Collections.emptyList();
            }

        }
        return ResponseEntity.ok(logs);
    }



}
