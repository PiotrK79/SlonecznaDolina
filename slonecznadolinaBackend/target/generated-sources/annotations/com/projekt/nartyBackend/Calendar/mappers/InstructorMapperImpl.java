package com.projekt.nartyBackend.Calendar.mappers;

import com.projekt.nartyBackend.Calendar.dtos.InstructorRequest;
import com.projekt.nartyBackend.Calendar.entities.Instructor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T17:23:54+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class InstructorMapperImpl implements InstructorMapper {

    @Override
    public Instructor toEntity(InstructorRequest request) {
        if ( request == null ) {
            return null;
        }

        Instructor instructor = new Instructor();

        instructor.setFirstName( request.getFirstName() );
        instructor.setLastName( request.getLastName() );

        return instructor;
    }
}
