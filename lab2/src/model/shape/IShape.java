package model.shape;

import model.stuff.Position;

public interface IShape {
    void setRadius(float r);
    boolean contains(Position position);
}
