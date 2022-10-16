package agh.ics.oop;
import java.util.Objects;

public class Vector2d {

    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(position1.add(MapDirection.NORTH.toUnitVector()));

    }

    public final int x;
    public final int y;


    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        String str;
        str = "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + ")";
        return str;
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        int new_x = Math.max(this.x, other.x);
        int new_y = Math.max(this.y, other.y);
        return new Vector2d(new_x, new_y);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int new_x = Math.min(this.x, other.x);
        int new_y = Math.min(this.y, other.y);
        return new Vector2d(new_x, new_y);
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    public boolean equals(Vector2d other){
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass()){
            return false;
        }
        return Objects.equals(this.x, ((Vector2d) other).x) && Objects.equals(this.y, ((Vector2d) other).y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}