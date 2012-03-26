package model.shape;

import model.stuff.Position;
import model.stuff.Strategy;
import model.stuff.Util;

public class TriangleShape extends BaseShape {
    public TriangleShape(Strategy strategy) {
        super(strategy);
    }

    private float getCoefficientSlope() {
        return -getUnfixedPosition().getY() / getUnfixedPosition().getX();
    }

    private float getFreeTerm() {
        return getUnfixedPosition().getY();
    }

    private Position getPositionByX(float x) {
        float y = getCoefficientSlope() * x + getFreeTerm();
        return new Position(x, y);
    }

    public boolean contains(Position position) {
        if (!Util.isBetweenPositions(position, getFixedPosition(), getUnfixedPosition())) {
            return false;
        }
        Position positionToCompare = getPositionByX(position.getX());
        float searchedDistance = Util.getDistance(getFixedPosition(), position);
        float maxDistance = Util.getDistance(getFixedPosition(), positionToCompare);
        return searchedDistance <= maxDistance;
    }
}
