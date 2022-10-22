package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d position;


    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);

    }
    public String toString(){
        String str = "";
        str += "position: " + String.valueOf(this.position) + "\nfacing " + String.valueOf(this.direction);
        return str;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            // komentarz z odpowiedzia do chyba 10 pkt na upel w komentarzu pod rar zip czy co tam masz
        }
    }
}
