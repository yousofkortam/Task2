/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming3task2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author ikort
 */
public class Programming3Task2 extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        
        // Top Pane
        HBox top = new HBox(10);
        Label label1 = new Label("Enter Text:");
        final TextField textfield = new TextField("JavaFx Example");
        textfield.setPrefWidth(300);
        top.setPadding(new Insets(15));
        top.getChildren().addAll(label1, textfield);
        top.setAlignment(Pos.CENTER);
        
        // Bottom Pane
        HBox bottom = new HBox(10);
        Image leftImage = new Image("left.jpeg") {};
        ImageView imageview1 = new ImageView(leftImage);
        imageview1.setFitWidth(30);
        imageview1.setFitHeight(30);
        Image rightImage = new Image("right.jpeg");
        ImageView imageview2 = new ImageView(rightImage);
        imageview2.setFitWidth(30);
        imageview2.setFitHeight(30);
        Button button1 = new Button("Move Left", imageview1);
        Button button2 = new Button("Move Right", imageview2);

        bottom.setPadding(new Insets(15));
        bottom.getChildren().addAll(button1, button2);
        bottom.setAlignment(Pos.CENTER);
        
        
        // Center Pane
        Pane center = new Pane();
        final Text textArea = new Text(20, 20, "JavaFX Example");
        center.getChildren().add(textArea);
        center.setStyle("-fx-border-color: black");
        
        
        // Left Pane
        GridPane left = new GridPane();
        Label label = new Label("Select Color: ");
        RadioButton red = new RadioButton("Red");
        RadioButton green = new RadioButton("Green");
        RadioButton blue = new RadioButton("Blue");
        ToggleGroup togglegroup = new ToggleGroup();
        red.setToggleGroup(togglegroup);
        green.setToggleGroup(togglegroup);
        blue.setToggleGroup(togglegroup);
        left.setVgap(8);
        left.setPadding(new Insets(10));
        left.addColumn(0, label, red, green, blue);
        
        
        // Right Pane
        VBox right = new VBox(10);
        Label sizeLabel = new Label("Select Font Size: ");
        final ComboBox<Integer> numbers = new ComboBox<>();
        numbers.getItems().addAll(8, 9, 10, 11);
        for (int i = 12; i <= 72; i+=2) {
            numbers.getItems().add(i);
        }
        numbers.setValue(10);
        
        Label style = new Label("Select Style:");
        final CheckBox checKbox1 = new CheckBox("Bold");
        final CheckBox checKbox2 = new CheckBox("Italic");
        right.setPadding(new Insets(15));
        right.getChildren().addAll(sizeLabel, numbers, style, checKbox1, checKbox2);
        
        
        
        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setRight(right);
        root.setBottom(bottom);
        root.setLeft(left);
        root.setCenter(center);
        
        
        // Controllers
        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                textArea.setX(textArea.getX() - 10);
            }
        });
        
        button2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                textArea.setX(textArea.getX() + 10);
            }
        });
        
        textfield.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String newText = textfield.getText();
                textArea.setText(newText);
            }
        });

        red.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                textArea.setFill(Color.RED);
            }
        });
        
        green.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                textArea.setFill(Color.GREEN);
            }
        });
        
        blue.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                textArea.setFill(Color.BLUE);
            }
        });
        
        checKbox1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (checKbox1.isSelected() && checKbox2.isSelected()) {
                    textArea.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, numbers.getValue()));
                } else if (checKbox1.isSelected() && !checKbox2.isSelected()) {
                    textArea.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, numbers.getValue()));
                } else if (!checKbox1.isSelected() && checKbox2.isSelected()) {
                    textArea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, numbers.getValue()));
                } else if (!checKbox1.isSelected() && !checKbox2.isSelected()) {
                    textArea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, numbers.getValue()));
                }
            }
        });
        
        checKbox2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (checKbox1.isSelected() && checKbox2.isSelected()) {
                    textArea.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.ITALIC, numbers.getValue()));
                } else if (checKbox1.isSelected() && !checKbox2.isSelected()) {
                    textArea.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.REGULAR, numbers.getValue()));
                } else if (!checKbox1.isSelected() && checKbox2.isSelected()) {
                    textArea.setFont(Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.ITALIC, numbers.getValue()));
                } else if (!checKbox1.isSelected() && !checKbox2.isSelected()) {
                   textArea.setFont(Font.font("Times New Roman", FontWeight.NORMAL,FontPosture.REGULAR, numbers.getValue()));
                }
            }
        });
        
        
        
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Hello World!");
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
