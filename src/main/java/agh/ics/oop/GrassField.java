package agh.ics.oop;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.sqrt;

public class GrassField implements IWorldMap{

    public GrassField(int n){
        int maxrange = (int) sqrt(n*10);
        List<int> = avaliable_
        int randomNum = ThreadLocalRandom.current().nextInt(0, maxrange + 1);

    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
