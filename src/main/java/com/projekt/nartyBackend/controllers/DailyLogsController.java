package com.projekt.nartyBackend.controllers;

import com.projekt.nartyBackend.entities.DailyLogs;
import com.projekt.nartyBackend.repositories.DailyLogsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/log")
@AllArgsConstructor
public class DailyLogsController {
    private final DailyLogsRepository dailyLogsRepository;


    public ResponseEntity<DailyLogs> saveDailyLogs(@RequestBody DailyLogs dailyLogs,
                                                   UriComponentsBuilder uriBuilder) {
        var uri = uriBuilder.path("/log/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(null);
    }
}
