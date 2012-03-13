package com.dymsha.spip.lab1.core;

import com.dymsha.spip.lab1.core.shape.OurPoint;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. User: evgenij Date: 3/11/11 Time: 5:38 AM To change
 * this template use File | Settings | File Templates.
 */
public class HitChecker {

    public List<OurPoint> checkPoints(final Area area, final List<OurPoint> points) {
        final List<OurPoint> res = new ArrayList<OurPoint>();

        for (OurPoint point : points) {
            if (area.containPoint(point)) {
                res.add(point);
            }
        }

        return res;
    }

    public boolean checkPoint(final Area area, final OurPoint point) {
        return area.containPoint(point);

    }
}
