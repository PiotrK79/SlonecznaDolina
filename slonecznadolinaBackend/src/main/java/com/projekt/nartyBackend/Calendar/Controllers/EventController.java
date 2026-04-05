package com.projekt.nartyBackend.Calendar.Controllers;

import com.projekt.nartyBackend.Calendar.Services.EventService;
import com.projekt.nartyBackend.Calendar.dtos.EventRequest;
import com.projekt.nartyBackend.Calendar.entities.Event;
import com.projekt.nartyBackend.Calendar.mappers.EventMapper;
import com.projekt.nartyBackend.Calendar.repositories.EventRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.file.AccessDeniedException;
import java.util.*;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {
    private final EventRepository eventRepository;
    private final EventService eventService;
    private final EventMapper eventMapper;

    @PostMapping
    public ResponseEntity<Event> createEvent(@Valid @RequestBody EventRequest request,
                                             UriComponentsBuilder uriBulder) {
        Event ev = eventService.createEvent(request);
        var uri = uriBulder.path("/event/{id}").buildAndExpand(ev.getId()).toUri();
        return ResponseEntity.created(uri).body(ev);
    }

    /*@GetMapping()
    public ResponseEntity<List<Event>> getAllEvents(@RequestParam(required = false) String email) {
        List<Event> events = eventService.getAllEvents(email)

        return ResponseEntity.ok(events);
    }*/

    @GetMapping
    public ResponseEntity<List<Event>> getAllEventsOfLoggedUser() throws AccessDeniedException {
        List<Event> events = eventService.getAllEventsOfLoggedUser();

        return ResponseEntity.ok(events);
    }


    /*@GetMapping("/id")
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
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@Valid @RequestBody EventRequest request,
                                             @PathVariable Long id,
                                             UriComponentsBuilder uriBulder) throws AccessDeniedException {
        var updatedEvent = eventService.updateEvent(request,id);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) throws AccessDeniedException {
        boolean check = eventService.deleteEvent(id);
        if(!check) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

}
