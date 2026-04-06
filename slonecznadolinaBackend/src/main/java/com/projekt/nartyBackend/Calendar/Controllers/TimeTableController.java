package com.projekt.nartyBackend.Calendar.Controllers;

import com.projekt.nartyBackend.Calendar.Services.TimeTableService;
import com.projekt.nartyBackend.Calendar.dtos.EmptyTableRequest;
import com.projekt.nartyBackend.Calendar.entities.Event;
import com.projekt.nartyBackend.Calendar.entities.TimeTable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/table")
@RequiredArgsConstructor
public class TimeTableController {
    TimeTableService timeTableService;

    @PostMapping
    public ResponseEntity<TimeTable> createTimeTable(@Valid @RequestBody EmptyTableRequest request) {
        timeTableService.createTimeTable(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<TimeTable> getTimeTable() {
        return ResponseEntity.ok().build();//TODO
    }
    @PutMapping("/{id}/add")
    public ResponseEntity<TimeTable> addEventToTimeTable(@Valid @RequestBody Event request, @PathVariable Long id) {
        TimeTable table = timeTableService.addEventToTable(id, request);
        return ResponseEntity.ok().body(table);
    }

    @PutMapping("/{id}/remove")
    public ResponseEntity<TimeTable> removeEventFromTimeTable(@Valid @RequestBody Event request, @PathVariable Long id) {
        TimeTable table = timeTableService.removeEventFromTable(id,request);
        return ResponseEntity.ok().body(table);
    }


}
