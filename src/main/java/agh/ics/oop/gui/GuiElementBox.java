package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox{

    Image image;
    ImageView imageView;
    Label label;
    VBox vbox;

    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        try {
            image = new Image(new FileInputStream(element.getImagePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("File does not exist");
        }
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        if(element instanceof Animal){
            label = new Label("Z" + element.getPosition().toString());
        }
        else{
            label = new Label("Trawa");
        }
        vbox = new VBox();
        vbox.getChildren().addAll(imageView, label);
        vbox.setAlignment(Pos.CENTER);
    }
}
