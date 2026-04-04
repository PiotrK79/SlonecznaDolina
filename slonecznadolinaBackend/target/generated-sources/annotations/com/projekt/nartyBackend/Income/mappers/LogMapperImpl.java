package com.projekt.nartyBackend.Income.mappers;

import com.projekt.nartyBackend.Income.dto.UploadLogRequest;
import com.projekt.nartyBackend.Income.entities.Log;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T17:23:54+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class LogMapperImpl implements LogMapper {

    @Override
    public Log toEntity(UploadLogRequest uploadLogRequest) {
        if ( uploadLogRequest == null ) {
            return null;
        }

        Log log = new Log();

        log.setQuantity( uploadLogRequest.getQuantity() );

        return log;
    }
}
