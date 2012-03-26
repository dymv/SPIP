package model.shape;

import model.stuff.Position;
import model.stuff.Strategy;
import model.stuff.Util;

public class RectangleShape extends BaseShape {
    public RectangleShape(Strategy unfixedPositionStrategy) {
        super(unfixedPositionStrategy);
    }

    public boolean contains(Position position) {
        return Util.isBetweenPositions(position, getFixedPosition(), getUnfixedPosition());
    }
}
