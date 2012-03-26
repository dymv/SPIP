package model.shape;

import model.stuff.Position;
import model.stuff.Strategy;

public abstract class BaseShape implements IShape {
    private final Position myFixedPosition = new Position(0, 0);
    private Strategy myStrategy;
    private float myRadius;

    public BaseShape(Strategy strategy) {
        myStrategy = strategy;
    }

    public float getRadius() {
        return myRadius;
    }

    public void setRadius(float radius) {
        myRadius = radius;
    }

    public Position getUnfixedPosition() {
        return myStrategy.compute(getRadius());
    }

    public Position getFixedPosition() {
        return myFixedPosition;
    }
}
