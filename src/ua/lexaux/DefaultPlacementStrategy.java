package ua.lexaux;

import ua.lexaux.model.CalendarEvent;
import ua.lexaux.view.Box;

/**
 * Different ways of setting up strategies.
 */
public class DefaultPlacementStrategy {
    public static final int MINUTES_IN_DAY = 24 * 60;

    private final int columnXOffset;
    private final int columnWidth;
    private final float pixelsPerMinute;

    public DefaultPlacementStrategy(int columnXOffset, int columnWidth, int columnHeight) {
        this.columnWidth = columnWidth;
        this.columnXOffset = columnXOffset;
        this.pixelsPerMinute = (float)columnHeight / MINUTES_IN_DAY;
    }

    public Box multiColumnPlacement(CalendarEvent event) {
        Box box = new Box();

        box.xPixels = columnXOffset;
        box.width = columnWidth;

        int minutesFromDayStart = event.getLocalDateTime().getHour() * 60 + event.getLocalDateTime().getMinute();
        box.yPixels = Math.round(minutesFromDayStart * pixelsPerMinute);
        box.height = Math.round(event.getDuration().toMinutes() * pixelsPerMinute);

        return box;

    }

    public static PlacementStrategy createOneColumnPlacement(final int totalHeight, final int totalWidth) {
        DefaultPlacementStrategy str = new DefaultPlacementStrategy(0, totalWidth, totalHeight);
        return str::multiColumnPlacement;
    }

}