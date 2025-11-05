package com.projekt.nartyBackend.controllers;

import com.projekt.nartyBackend.dto.UploadTicketRequest;
import com.projekt.nartyBackend.entities.Karnet;
import com.projekt.nartyBackend.mappers.TicketMapper;
import com.projekt.nartyBackend.repositories.KarnetRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketsController {
    private final KarnetRepository karnetRepository;
    private final TicketMapper ticketMapper;

    @PostMapping
    public ResponseEntity<Karnet> toEntity(@RequestBody UploadTicketRequest request,
                                           UriComponentsBuilder uriBuilder) {
        var ticket = ticketMapper.toEntity(request);
        karnetRepository.save(ticket);
        var uri = uriBuilder.path("/tickets/{id}").buildAndExpand(ticket.getId()).toUri();
        System.out.println(request);
        System.out.println(ticket);
        return ResponseEntity.created(uri).body(ticket);
    }

}
