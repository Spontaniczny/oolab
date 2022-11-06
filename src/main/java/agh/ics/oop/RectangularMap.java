package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height){
        this.height = height;
        this.width = width;
        this.obj = new MapVisualizer(this);
    }
}
