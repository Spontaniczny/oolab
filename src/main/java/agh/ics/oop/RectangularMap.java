package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap implements IWorldMap, IPositionChangeObserver{


    public RectangularMap(int width, int height){
        this.lower_left = new Vector2d(0, 0);
        this.upper_right = new Vector2d(width, height);
        this.obj = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && this.lower_left.precedes(position) && this.upper_right.follows(position);
    }
}
