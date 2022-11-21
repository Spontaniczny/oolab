package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Map<Vector2d, Grass> grass_fields = new HashMap<>();

    protected Vector2d lower_left;
    protected Vector2d upper_right;
    protected MapVisualizer obj;

    public String toString(){
        Vector2d[] bounds = getMapBounds();
        return this.obj.draw(bounds[0], bounds[1]);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        for(Animal animal: this.animals.values()){
            if(position.equals(animal.getPosition())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal){
        Vector2d position = animal.getPosition();
        if(isOccupied(position)){
            if(objectAt(position) instanceof Animal){
                throw new IllegalArgumentException("Position: " + position + " is already occupied by another animal.");
            }
        }
        this.animals.put(position, animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return this.animals.containsKey(position) || this.grass_fields.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(this.animals.get(position) != null){
            return this.animals.get(position);
        }
        if(this.grass_fields.get(position) != null){
            return this.grass_fields.get(position);
        }
        return null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals.get(oldPosition);
        this.animals.put(newPosition, animal);
        this.animals.remove(oldPosition);
    }

    public Vector2d[] getMapBounds(){
        return new Vector2d[]{lower_left, upper_right};
    }
}
