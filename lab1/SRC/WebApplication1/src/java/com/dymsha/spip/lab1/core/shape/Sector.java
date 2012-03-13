package com.dymsha.spip.lab1.core.shape;

/**
 * Created by IntelliJ IDEA.
 * User: evgenij
 * Date: 3/10/11
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sector implements Shape {
    private Quadrant quadrant;
    private double radius;

    public Sector(Quadrant quadrant, double radius) {
        this.quadrant = quadrant;
        this.radius = radius;
    }

    public boolean containPoint(OurPoint point) {
        switch (quadrant) {
            case FIRST:
                if ((point.getX() < 0) || (point.getY() < 0)) {
                    return false;
                }
                break;
            case SECOND:
                if ((point.getX() > 0) || (point.getY() < 0)) {
                    return false;
                }
                break;
            case THIRD:
                if ((point.getX() > 0) || (point.getY() > 0)) {
                    return false;
                }
                break;
            case FOURTH:
                if ((point.getX() < 0) || (point.getY() > 0)) {
                    return false;
                }
                break;
        }

        return pointInDaCircle(point, radius);
    }

    private boolean pointInDaCircle(OurPoint point, double radius) {
        if ((Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2)) <= Math.pow(radius, 2)) {
            return true;
        }
        return false;
    }

}
