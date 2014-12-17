package ua.lexaux;

import ua.lexaux.view.Box;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Entry point.
 */
public class EntryPoint {

    public static Function<? super Box, ?> identityPrintingMapper = b -> {
        System.out.println(b);
        return b;
    };

    public static void main(String[] args) {
        List<Object> objects = Stream.generate(Box::new).limit(100).collect(Collectors.toList());

        // create a couple of views with different placement strategies
        CalendarView view1 = new CalendarView(DefaultPlacementStrategy.createOneColumnPlacement(1000, 200));

        DefaultPlacementStrategy dps = new DefaultPlacementStrategy(100, 100, 2000);

        CalendarView view2 = new CalendarView(((PlacementStrategy) dps::multiColumnPlacement).padded(20));

        CalendarView view3 = new CalendarView(event -> new Box(0, 0, 100, 100));

        List<Box> placedEvents = view1.placeEvents();
        List<Box> placedEvents2 = view2.placeEvents();
        List<Box> placedEvents3 = view3.placeEvents();

        // concat all streams, and print them out.
        Stream.concat(
                Stream.concat(placedEvents.stream(), placedEvents2.stream()), placedEvents3.stream())
                .map(identityPrintingMapper)
                .collect(Collectors.counting());
    }

}
