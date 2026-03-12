package com.projekt.nartyBackend.Calendar.Controllers;

import com.projekt.nartyBackend.Calendar.dtos.InstructorRequest;
import com.projekt.nartyBackend.Calendar.entities.Instructor;
import com.projekt.nartyBackend.Calendar.mappers.InstructorMapper;
import com.projekt.nartyBackend.Calendar.repositories.InstructorRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@AllArgsConstructor
public class InstructorController {

    private InstructorRepository instructorRepository;
    private InstructorMapper instructorMapper;

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@Valid @RequestBody InstructorRequest request,
                                                       UriComponentsBuilder uriBuilder) {
        var instructor = instructorMapper.toEntity(request);
        System.out.println(instructor.toString());
        instructorRepository.save(instructor);
        var uri = uriBuilder.path("/instructor/{id}").buildAndExpand(instructor.getId()).toUri();
        return ResponseEntity.created(uri).body(instructor);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {return ResponseEntity.ok(instructorRepository.findAll());}
}
