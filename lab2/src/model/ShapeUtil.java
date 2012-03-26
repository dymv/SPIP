package model;

import model.shape.*;
import model.stuff.Position;
import model.stuff.Strategy;

public class ShapeUtil {

    public static BaseShape getLab2Shape() {
        final CircleSectorShape circleSector = new CircleSectorShape(new Strategy() {
            public Position compute(float radius) {
                return new Position(- radius / 2, -radius / 2);
            }
        });

        final RectangleShape rectangle = new RectangleShape(new Strategy() {
            public Position compute(float radius) {
                return new Position(- radius / 2, radius);
            }
        });

        final TriangleShape triangle = new TriangleShape(new Strategy() {
            public Position compute(float radius) {
                return new Position(radius, - radius / 2);
            }
        });

        final MultipleShape shape = new MultipleShape();
        shape.addShape(circleSector);
        shape.addShape(rectangle);
        shape.addShape(triangle);
        shape.setRadius(1);
        return shape;
    }

}
