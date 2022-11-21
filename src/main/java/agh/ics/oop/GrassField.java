package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap implements IPositionChangeObserver{

    private final int number_of_grass;


    public GrassField(int n){
        this.number_of_grass = n;
        add_grass();
        this.obj = new MapVisualizer(this);
    }

    private void add_grass(){
        Random rand = new Random();
        int range_of_grass = (int) ((sqrt(this.number_of_grass*10)+1)*(sqrt(this.number_of_grass*10)+1));
        List<Integer> available_grass_fields = new ArrayList<>();
        for(int i = 0; i < range_of_grass; i++){
            available_grass_fields.add(i);
        }
        int temp;
        for(int i = 0; i < this.number_of_grass; i++){
            temp = available_grass_fields.remove(rand.nextInt(range_of_grass - 1 - i));
            Grass grass = new Grass(new Vector2d(temp / this.number_of_grass, temp % this.number_of_grass));
//            this.grass_fields.put(new Vector2d(temp / this.number_of_grass, temp % this.number_of_grass), grass);
            this.grass_fields.put(grass.getPosition(), grass);
            mapBoundary.AddGrass(grass);
        }
    }

    @Override
    public Vector2d[] getMapBounds(){
        return new Vector2d[]{mapBoundary.GetBottomLeft(), mapBoundary.GetTopRight()};
    }

}

