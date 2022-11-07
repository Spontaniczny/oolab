package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected int height;
    protected int width;
//    protected List<Animal> animals = new ArrayList<>();
    Map<Vector2d, Animal> animals = new HashMap<>();
    protected List<Grass> grass_fields = new ArrayList<>();

    protected MapVisualizer obj;

    public String toString(){
        return this.obj.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(0 > position.x || 0 > position.y || position.x > this.width || position.y > this.height) {
            return false;
        }
        if(isOccupied(position)){
            return !(objectAt(position) instanceof Animal);
        }
        return true;
    }

    @Override
    public boolean place(Animal animal){
        Vector2d position = animal.getPosition();
        if(isOccupied(position)){
            if(objectAt(position) instanceof Animal){
                return false;
            }
        }
        this.animals.put(position, animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for(Grass grass: grass_fields){
            if(grass.getPosition().equals(position)){
                return true;
            }
        }
        return this.animals.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        var obj = this.animals.get(position);

        if(this.animals.get(position) != null){
            return this.animals.get(position);
        }
        for(Grass grass: grass_fields){
            if(grass.getPosition().equals(position)){
                return grass;
            }
        }
        return null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        this.animals.put(newPosition, this.animals.remove(oldPosition));
    }
}
