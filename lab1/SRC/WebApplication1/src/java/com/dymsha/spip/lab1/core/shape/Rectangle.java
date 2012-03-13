package com.dymsha.spip.lab1.core.shape;

/**
 * Created by IntelliJ IDEA.
 * User: evgenij
 * Date: 3/10/11
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rectangle implements Shape {
    private OurPoint apex;
    private double width, height;

    public Rectangle(final OurPoint apex, final double width, final double height) {
        this.apex = apex;
        this.width = width;
        this.height = height;
    }

    public Rectangle(final double x, final double y, final double width, final double height) {
        this.apex = new OurPoint(x,y);
        this.width = width;
        this.height = height;
    }

    public boolean containPoint(final OurPoint point) {
        return ( height >= 0 ? (point.getY() >= apex.getY() && point.getY() <= apex.getY() + height)
                             : (point.getY() <= apex.getY() && point.getY() >= apex.getY() + height))
                && ( width >= 0 ? point.getX() >= apex.getX() && point.getX() <= apex.getX() + width
                                : point.getX() <= apex.getX() && point.getX() >= apex.getX() + width);
    }
}
