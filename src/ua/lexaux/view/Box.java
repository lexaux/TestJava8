package ua.lexaux.view;

/**
 */

public class Box {
    public Box() {
    }

    public Box(int xPixels, int yPixels, int width, int height) {
        this.xPixels = xPixels;
        this.yPixels = yPixels;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Box [%1$d %2$d %3$d %4$d]", xPixels, yPixels, width, height);
    }

    public int xPixels;
    public int yPixels;
    public int width;
    public int height;
}
