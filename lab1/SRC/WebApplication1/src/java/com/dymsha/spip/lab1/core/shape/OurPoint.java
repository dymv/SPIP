package com.dymsha.spip.lab1.core.shape;

/**
 * Created by IntelliJ IDEA.
 * User: evgenij
 * Date: 3/11/11
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class OurPoint implements Shape {
    private final double x, y;

    public OurPoint(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public boolean containPoint(OurPoint point) {
        return point.getX() == x && point.getY() == y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
