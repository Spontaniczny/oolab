package agh.ics.oop;

public class Animal{
    private MapDirection direction;
    private Vector2d position;
    IWorldMap map;


    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map){
        this.map = map;
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.direction = MapDirection.NORTH;
        this.position = initialPosition;
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
                    this.position = new_position;
                }
            }
            case BACKWARD -> {
                Vector2d new_position = this.position.add(this.direction.toUnitVector().opposite());
                if(this.map.canMoveTo(new_position)){
                    this.position = new_position;
                }
            }
        }
    }
}

