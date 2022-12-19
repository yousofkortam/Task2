/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming3task2;

import java.awt.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ikort
 */
public class Programming3Task2 extends Application {
    
    
    public HBox Top() {
        HBox hbox = new HBox();

        Label label = new Label("Enter Text: ");
        TextField textField = new TextField("Press Enter to change Text");
        hbox.getChildren().addAll(label, textField);
        hbox.setSpacing(20);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }
   
    
    public VBox Left() {
        VBox hbox = new VBox();

        Label label = new Label("Select Color:");

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Red");
        rb1.setToggleGroup(toggleGroup);
        RadioButton rb2 = new RadioButton("Green");
        rb2.setToggleGroup(toggleGroup);
        RadioButton rb3 = new RadioButton("Blue");
        rb3.setToggleGroup(toggleGroup);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(rb1, rb2, rb3);
        vbox.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(label, vbox);
        hbox.setSpacing(20);

        return hbox;
    }
    
    public VBox Right() {
        VBox vbox = new VBox();

        Label label = new Label("Selector: ");
        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(8, 9, 10, 11);
        for (int i = 12; i <= 72; i+=2) {
            comboBox.getItems().add(i);
        }
        comboBox.setValue(10);

        CheckBox cb1 = new CheckBox("Bold");
        CheckBox cb2 = new CheckBox("Italic");

        vbox.getChildren().addAll(label, comboBox, cb1, cb2);
        vbox.setSpacing(20);

        return vbox;
    }
    
    public StackPane Center() {
        StackPane stackPane = new StackPane();
        TextArea textArea = new TextArea();
        stackPane.getChildren().add(textArea);
        return stackPane;
    }
    
    public HBox createButtons() {
        HBox hbox = new HBox();

        // Create the first button
        Button button1 = new Button();
        button1.setText("Move Left");
        ImageView imageView1 = new ImageView(new Image(getClass().getResourceAsStream("left-arrow.png")));
        button1.setGraphic(imageView1);

        // Create the second button
        Button button2 = new Button();
        button2.setText("Move Right");
        ImageView imageView2 = new ImageView(new Image(getClass().getResourceAsStream("right-arrow.png")) {});
        button2.setGraphic(imageView2);

        hbox.getChildren().addAll(button1, button2);
        hbox.setSpacing(10);

        return hbox;
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();

        HBox topPane = Top();
        // add nodes to the topPane HBox here

        HBox bottomPane = new HBox();
        // add nodes to the bottomPane HBox here
        
        
        VBox rightPane = Right();
        // add nodes to the rightPane HBox here
        
        VBox leftPane = Left();
        // add nodes to the leftPane VBox here
        
        Pane centerPane = Center();
        // add nodes to the centerPane VBox here

        root.setTop(topPane);
        root.setBottom(bottomPane);
        root.setCenter(centerPane);
        root.setLeft(Left());
        root.setRight(rightPane);

        // Set the scene and show the stage
        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
