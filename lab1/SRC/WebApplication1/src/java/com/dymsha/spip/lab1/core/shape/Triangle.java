package com.dymsha.spip.lab1.core.shape;

/**
 * Created by IntelliJ IDEA.
 * User: evgenij
 * Date: 3/10/11
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Triangle implements Shape {
    private  double height, width;

    public Triangle(double width, double height) {
        this.height = height;
        this.width = width;
    }
    
    public boolean containPoint(OurPoint point) {

        if (point.getX() * width >= 0 && point.getY() * height >= 0) {
            if (height >= 0) {
                if (height * (-1 * point.getX()/width + 1) >= point.getY()) {
                    return true;
                }
            } else {
                if (height * (-1 * point.getX()/width + 1) <= point.getY()) {
                    return true;
                }
            }
        }

        return false;
    }

}
