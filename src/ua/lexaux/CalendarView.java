package ua.lexaux;

import ua.lexaux.model.CalendarEvent;
import ua.lexaux.view.Box;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.random;

/**
 */
public class CalendarView {

    public static final int MAX_SIZE = 100;
    public static final int MAX_DURATION_MINUTES = 4 * 60;
    public static final int MAX_OFFSET_MINUTES = 60 * 6;

    private List<CalendarEvent> events;
    private final PlacementStrategy strategy;

    public CalendarView(PlacementStrategy strategy) {
        this.events = generateTestData();
        this.strategy = strategy;
    }

    private List<CalendarEvent> generateTestData() {
        Supplier<CalendarEvent> supplier = () -> new CalendarEvent(
                (random() > .5) ?
                        (LocalDateTime.now().minusMinutes((long) (random() * MAX_OFFSET_MINUTES))) :
                        (LocalDateTime.now().plusMinutes((long) (random() * MAX_OFFSET_MINUTES))),

                Duration.ofMinutes((long) (MAX_DURATION_MINUTES * random())));

        List<CalendarEvent> testEvents =
                Stream.generate(supplier)
                        .limit(MAX_SIZE)
                        .filter(e -> e.getLocalDateTime().isBefore(LocalDateTime.now()))
                        .collect(Collectors.toList());

        return testEvents;
    }

    public List<Box> placeEvents() {
        return events.stream().map(e -> strategy.placeEvent(e)).collect(Collectors.toList());
    }



}
