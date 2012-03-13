package com.dymsha.spip.lab1.core;

import com.dymsha.spip.lab1.core.shape.OurPoint;
import com.dymsha.spip.lab1.core.shape.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: evgenij
 * Date: 3/10/11
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */

public class DescartesArea implements Area {
    private List<Shape> shapes;

    public DescartesArea() {
        shapes = new ArrayList<Shape>();
    }

    public void addShape(final Shape shape) {
        shapes.add(shape);
    }

    public boolean containPoint(OurPoint point) {
        for (final Shape shape : shapes) {
            if (shape.containPoint(point)) {
                return true;
            }
        }

        return false;
    }
}
