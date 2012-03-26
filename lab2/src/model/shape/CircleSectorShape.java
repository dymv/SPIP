package model.shape;

import model.stuff.Position;
import model.stuff.Strategy;
import model.stuff.Util;

public class CircleSectorShape extends BaseShape {
    public CircleSectorShape(Strategy circleRadiusStrategy) {
        super(circleRadiusStrategy);
    }

    private float getCircleRadius() {
        return Math.abs(getUnfixedPosition().getX() - getFixedPosition().getX());
    }

    public boolean contains(Position position) {
        Position maxPosition = getUnfixedPosition();
        if (!Util.isBetweenPositions(position, getFixedPosition(), maxPosition)) {
            return false;
        }
        float positionRadius = Util.getDistance(position, getFixedPosition());
        return positionRadius <= getCircleRadius();
    }
}
