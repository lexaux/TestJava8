package ua.lexaux;

import ua.lexaux.model.CalendarEvent;
import ua.lexaux.view.Box;

/**
 * Placement Strategy Interface.
 */
@FunctionalInterface //need this for compiler to check if this is really maintaining contract of functional interface
public interface PlacementStrategy {

    // actual functional interface method.
    Box placeEvent(CalendarEvent event);

    default PlacementStrategy padded(int padding) {
        return (event) -> {
            Box box = PlacementStrategy.this.placeEvent(event);
            box.height -= 2 * padding;
            box.width -= 2 * padding;
            box.xPixels += padding;
            box.yPixels += padding;
            return box;
        };
    }

    default PlacementStrategy offset(int offsetX, int offsetY) {
        int x;   //needed for closure limitation illustrations
        return (event) -> {
            Box box = PlacementStrategy.this.placeEvent(event);
            box.xPixels += offsetX;
            box.yPixels += offsetY;// + x
            return box;
        };
    }

}
