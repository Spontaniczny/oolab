package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{
    private IWorldMap map;
    private MoveDirection[] moves;
    private List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        this.animals = new ArrayList<>();
        for(Vector2d position: positions){
            Animal animal = new Animal(this.map, position);
            this.animals.add(animal);
            this.map.place(animal);
        }
    }
    @Override
    public void run(){
        System.out.println("Thread started.");
        System.out.println(this.map);
        int n = animals.size();
        for(int i = 0; i < this.moves.length; i++){
            this.animals.get(i % n).move(moves[i]);
            System.out.println(this.map);
        }
    }
}
