package model;

import model.shape.BaseShape;
import model.stuff.Position;
import view.IView;

import java.util.ArrayList;
import java.util.List;

public class ChartModel {
    private List<IView> myViews = new ArrayList<IView>();
    Position myCurrentPosition = new Position(0, 0);
    BaseShape myShape;

    public ChartModel(BaseShape shape) {
        myShape = shape;
    }

    protected void updateViews() {
        for (IView view : myViews) {
            view.updateView();
        }
    }

    public void addView(IView view) {
        myViews.add(view);
    }

    public void setCurrentX(float x) {
      myCurrentPosition.setX(x);
      updateViews();
    }

    public void setCurrentY(float y) {
        myCurrentPosition.setY(y);
        updateViews();
    }

    public void setRadius(float r) {
        myShape.setRadius(r);
        updateViews();
    }

    public Position getCurrentPosition() {
        return myCurrentPosition;
    }

    public boolean containsCurrentPosition() {
      return myShape.contains(getCurrentPosition());
    }

}
