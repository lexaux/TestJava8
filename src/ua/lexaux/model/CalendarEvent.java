package ua.lexaux.model;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Event
 */
public class CalendarEvent {
    private final Duration duration;

    private final LocalDateTime localDateTime;

    public CalendarEvent(LocalDateTime dateTime, Duration duration) {
        this.localDateTime = dateTime;
        this.duration = duration;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Duration getDuration() {
        return duration;
    }
}
