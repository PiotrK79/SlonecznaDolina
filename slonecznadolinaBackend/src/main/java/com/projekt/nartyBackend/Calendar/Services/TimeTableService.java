package com.projekt.nartyBackend.Calendar.Services;

import com.projekt.nartyBackend.Auth.Repositories.UserRepository;
import com.projekt.nartyBackend.Calendar.dtos.EmptyTableRequest;
import com.projekt.nartyBackend.Calendar.entities.Event;
import com.projekt.nartyBackend.Calendar.entities.TimeTable;
import com.projekt.nartyBackend.Calendar.mappers.TimeTableMapper;
import com.projekt.nartyBackend.Calendar.repositories.EventRepository;
import com.projekt.nartyBackend.Calendar.repositories.TimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeTableService {
    private final TimeTableRepository timeTableRepository;
    private final TimeTableMapper timeTableMapper;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;


    public TimeTable createTimeTable(EmptyTableRequest request){
        TimeTable timeTable = timeTableMapper.toEntity(request);
        timeTableRepository.save(timeTable);
        return timeTable;
    }

    public TimeTable addEventToTable(Long id, Event event){
        TimeTable table = timeTableRepository.findById(id).orElse(null);
        if(table == null || event == null) return null;

        table.addEvent(event);
        timeTableRepository.save(table);
        return table;
    }

    public TimeTable removeEventFromTable(Long id, Event event){
        TimeTable table = timeTableRepository.findById(id).orElse(null);
        if(table == null || event == null||
                !table.getEvents().contains(event)
        ) return null;
        table.removeEvent(event);
        timeTableRepository.save(table);
        return table;
    }
}
