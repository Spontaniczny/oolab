package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private int height;
    private int width;
    private List<Animal> animals = new ArrayList<>();

    private MapVisualizer obj;

    public RectangularMap(int width, int height){
        this.height = height;
        this.width = width;
        this.obj = new MapVisualizer(this);
    }

    public String toString(){
        return this.obj.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(0 > position.x || 0 > position.y || position.x > this.width || position.y > this.height) {
        return false;
        }
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal){
        Vector2d position = animal.getPosition();
        if(isOccupied(position)){
            return false;
        }
        this.animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for(Animal animal: animals){
            if(animal.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: animals){
            if(animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }
}
