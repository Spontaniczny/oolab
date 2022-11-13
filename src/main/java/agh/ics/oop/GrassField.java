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
            this.grass_fields.put(new Vector2d(temp / this.number_of_grass, temp % this.number_of_grass), grass);
        }
    }

    @Override
    public Vector2d[] getMapBounds(){
        int min_x = Integer.MAX_VALUE;
        int max_x = 0;
        int min_y = Integer.MAX_VALUE;
        int max_y = 0;
        Vector2d pos;
        for(Animal animal: this.animals.values()){
            pos = animal.getPosition();
            min_x = min(min_x, pos.x);
            min_y = min(min_y, pos.y);
            max_x = max(max_x, pos.x);
            max_y = max(max_y, pos.y);
        }
        for(Grass grass: this.grass_fields.values()){
            pos = grass.getPosition();
            min_x = min(min_x, pos.x);
            min_y = min(min_y, pos.y);
            max_x = max(max_x, pos.x);
            max_y = max(max_y, pos.y);
        }
        return new Vector2d[]{new Vector2d(min_x, min_y), new Vector2d(max_x, max_y)};
    }

}
