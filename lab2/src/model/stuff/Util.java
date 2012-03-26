package model.stuff;

public class Util {
    private static boolean isBetweenCoordinates(float searchedValue, float value1, float value2) {
        float minValue = Math.min(value1, value2);
        float maxValue = Math.max(value1, value2);
        return searchedValue >= minValue && searchedValue <= maxValue;
    }

    public static boolean isBetweenPositions(Position searchedPosition, Position p1, Position p2) {
        return isBetweenCoordinates(searchedPosition.getX(), p1.getX(), p2.getX())
            && isBetweenCoordinates(searchedPosition.getY(), p1.getY(), p2.getY());
    }

    public static float getDistance(Position p1, Position p2) {
        float distanceX = p1.getX() - p2.getX();
        float distanceY = p1.getY() - p2.getY();
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);        
    }
}
