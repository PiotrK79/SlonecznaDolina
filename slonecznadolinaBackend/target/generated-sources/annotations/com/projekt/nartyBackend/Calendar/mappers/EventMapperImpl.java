package com.projekt.nartyBackend.Calendar.mappers;

import com.projekt.nartyBackend.Calendar.dtos.EventRequest;
import com.projekt.nartyBackend.Calendar.entities.Event;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-05T23:19:06+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public Event toEntity(EventRequest eventRequest) {
        if ( eventRequest == null ) {
            return null;
        }

        Event event = new Event();

        event.setStartTime( eventRequest.getStartTime() );
        event.setEndTime( eventRequest.getEndTime() );
        event.setTitle( eventRequest.getTitle() );
        event.setDescription( eventRequest.getDescription() );
        event.setUser( eventRequest.getUser() );

        return event;
    }

    @Override
    public void update(EventRequest eventRequest, Event event) {
        if ( eventRequest == null ) {
            return;
        }

        event.setStartTime( eventRequest.getStartTime() );
        event.setEndTime( eventRequest.getEndTime() );
        event.setTitle( eventRequest.getTitle() );
        event.setDescription( eventRequest.getDescription() );
        event.setUser( eventRequest.getUser() );
    }
}
