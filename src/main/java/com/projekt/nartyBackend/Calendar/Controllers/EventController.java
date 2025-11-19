package com.projekt.nartyBackend.Calendar.Controllers;

import com.projekt.nartyBackend.Calendar.dtos.EventRequest;
import com.projekt.nartyBackend.Calendar.entities.Event;
import com.projekt.nartyBackend.Calendar.mappers.EventMapper;
import com.projekt.nartyBackend.Calendar.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest request,
                                             UriComponentsBuilder uriBulder) {
        Event ev = eventMapper.toEntity(request);
        System.out.println(ev.toString());
        eventRepository.save(ev);
        var uri = uriBulder.path("/event/{id}").buildAndExpand(ev.getId()).toUri();
        return ResponseEntity.created(uri).body(ev);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents(@RequestParam(required = false) Long id) {
        List<Event> events;
        if(id == null) {
            events = eventRepository.findAll();
        }else {
            Optional<Event> ev = eventRepository.findById(id);
            if(ev.isPresent()) {
                events = List.of(ev.get());
            }else {
                events = Collections.emptyList();
            }
        }

        return ResponseEntity.ok(events);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@RequestBody EventRequest request,
                                             @PathVariable Long id,
                                             UriComponentsBuilder uriBulder) {
        var evO = eventRepository.findById(id).orElse(null);
        if(evO!=null) {
            eventMapper.update(request,evO);
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        var evO = eventRepository.findById(id).orElse(null);
        if(evO==null) {
            return ResponseEntity.notFound().build();
        }
        eventRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
