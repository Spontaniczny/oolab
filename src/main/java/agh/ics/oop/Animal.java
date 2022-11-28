package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{
    private MapDirection direction;
    private Vector2d position;

    private List<IPositionChangeObserver> observers = new ArrayList<>();
    IWorldMap map;


    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map){
        this.map = map;
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        addObserver((IPositionChangeObserver) map);
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.direction = MapDirection.NORTH;
        this.position = initialPosition;
        addObserver((IPositionChangeObserver) map);
    }
    public String toString(){
        return switch (this.direction){
            case NORTH ->  "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public Vector2d getPosition() {
        return this.position;
    }

    @Override
    public String getImagePath() {
        switch (this.direction){
            case NORTH -> {
                return "src/main/resources/up.png";
            }
            case EAST -> {
                return "src/main/resources/right.png";
            }
            case SOUTH -> {
                return "src/main/resources/down.png";
            }
            case WEST -> {
                return "src/main/resources/left.png";
            }
        }
        return null;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> {
                Vector2d new_position = this.position.add(this.direction.toUnitVector());
                if(this.map.canMoveTo(new_position)){
                    positionChanged(this.position, new_position);
                    this.position = new_position;
                }
            }
            case BACKWARD -> {
                Vector2d new_position = this.position.add(this.direction.toUnitVector().opposite());
                if(this.map.canMoveTo(new_position)){
                    positionChanged(this.position, new_position);
                    this.position = new_position;
                }
            }
        }
    }
    void positionChanged(Vector2d old_pos, Vector2d new_pos){
        for(IPositionChangeObserver observer: this.observers){
            observer.positionChanged(old_pos, new_pos);
        }
    }
    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
}

