package model.stuff;

public class Position {
    private float myX;
    private float myY;

    public Position(float x, float y) {
        myX = x;
        myY = y;
    }

    public float getX() {
        return myX;
    }

    public float getY() {
        return myY;
    }
    
    public void setX(float x) {
        myX = x;
    }

    public void setY(float y) {
        myY = y;
    }

  @Override
    public String toString() {
        return "x = " + myX + "\t y = " + myY;
    }
}
