package com.dymsha.spip.lab1;

import com.dymsha.spip.lab1.core.Area;
import com.dymsha.spip.lab1.core.AreaFactory;
import com.dymsha.spip.lab1.core.DescartesArea;
import com.dymsha.spip.lab1.core.shape.*;

/**
 * Created by IntelliJ IDEA.
 * User: evgenij
 * Date: 3/11/11
 * Time: 6:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class Lab1AreaFactory implements AreaFactory {

    public Area produceArea(double radius) {
        final DescartesArea lab1Area = new DescartesArea();
        lab1Area.addShape(new Triangle(0.5 * radius, 0.5 * radius));
        lab1Area.addShape(new Sector(Quadrant.THIRD, radius));
        lab1Area.addShape(new Rectangle(new OurPoint(0,0), 0.5 * radius, -1 * radius));
        return lab1Area;
    }
}
