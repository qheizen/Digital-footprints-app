package com.footprints.mappers;

import org.mapstruct.Named;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Named("asString")
    public String asString(LocalDateTime date) {
        return date != null ? date.format(FORMATTER) : null;
    }

    @Named("asDate")
    public LocalDateTime asDate(String date) {
        return date != null ? LocalDateTime.parse(date, FORMATTER) : null;
    }
}