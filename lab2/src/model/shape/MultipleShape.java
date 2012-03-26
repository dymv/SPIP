package model.shape;

import model.stuff.Position;

import java.util.HashSet;
import java.util.Set;

public class MultipleShape extends BaseShape {
    private Set<IShape> myParts = new HashSet<IShape>();

    public MultipleShape() {
        // position strategy can't be used
        super(null);
    }

    public void addShape(IShape shape) {
        myParts.add(shape);
    }

    @Override
    public void setRadius(float radius) {
        super.setRadius(radius);
        for (IShape part : myParts) {
            part.setRadius(radius);
        }
    }

    public boolean contains(Position position) {
        for (IShape part : myParts) {
            if (part.contains(position)) {
                return true;
            }
        }
        return false;
    }

    public Set<IShape> getShapes() {
        return myParts;
    }
}
