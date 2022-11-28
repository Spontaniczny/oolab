package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class ThreadSimulationEngine implements IEngine, Runnable{
    private IWorldMap map;
    private MoveDirection[] moves;
    private List<Animal> animals;
    private App app;

    public ThreadSimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions, App app){
        this.moves = moves;
        this.map = map;
        this.animals = new ArrayList<>();
        for(Vector2d position: positions){
            Animal animal = new Animal(this.map, position);
            this.animals.add(animal);
            this.map.place(animal);
        }
        this.app = app;
    }
    @Override
    public void run() throws RuntimeException{
        System.out.println("Thread started.");
        System.out.println(this.map);
        int n = animals.size();
        for(int i = 0; i < this.moves.length; i++){
            System.out.println(this.map);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                try {
                    app.drawGrid();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            this.animals.get(i % n).move(moves[i]);
        }
    }
}
