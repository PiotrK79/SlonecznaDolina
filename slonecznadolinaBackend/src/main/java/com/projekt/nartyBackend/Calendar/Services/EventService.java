package com.projekt.nartyBackend.Calendar.Services;

import com.projekt.nartyBackend.Auth.Entities.User;
import com.projekt.nartyBackend.Auth.Repositories.UserRepository;
import com.projekt.nartyBackend.Calendar.dtos.EventRequest;
import com.projekt.nartyBackend.Calendar.entities.Event;
import com.projekt.nartyBackend.Calendar.mappers.EventMapper;
import com.projekt.nartyBackend.Calendar.repositories.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final EventMapper eventMapper;

    public Event createEvent(EventRequest request){
        Event ev = eventMapper.toEntity(request);
        eventRepository.save(ev);
        return ev;
    }

    private User getLoggedUser() throws AccessDeniedException {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || auth.getName() == null){
            throw new AccessDeniedException("No auth or no email");
        }
        String email = auth.getName();

        return userRepository.findByEmail(email).orElseThrow(
                ()->new EntityNotFoundException("User not found"));
    }

    public List<Event> getAllEvents() throws AccessDeniedException {
        return eventRepository.findAll();
    }

    public List<Event> getAllEventsOfLoggedUser() throws AccessDeniedException {
        return eventRepository.findAllByUser(getLoggedUser());
    }

    public Event updateEvent(EventRequest request, Long id) throws AccessDeniedException {
        User activeUser = getLoggedUser();

        Event existingEvent = eventRepository.findById(id).orElse(null);

        if(existingEvent == null)return null;

        if(!existingEvent.getUser().getId().equals(activeUser.getId())) throw new AccessDeniedException("You are not allowed to update this event");

        existingEvent.setDescription(request.getDescription());
        existingEvent.setStartTime(request.getStartTime());
        existingEvent.setEndTime(request.getEndTime());
        existingEvent.setTitle(request.getTitle());
        existingEvent.setUser(request.getUser());

        eventRepository.save(existingEvent);

        return existingEvent;
    }

    public boolean deleteEvent(Long id) throws AccessDeniedException {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        User activeUser = getLoggedUser();
        if(!existingEvent.getUser().getId().equals(activeUser.getId()) )return false;
        eventRepository.delete(existingEvent);
        return true;
    }
}
