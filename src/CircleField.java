// Name: Joshua Francis
// Course: CSC 135
// Project: Problem_4_2
// File Name: CircleField.java

// This program displays a TextField with a circle around it, When you input
// a radius in the TextField, it redraws the circle to that inputted radius

// Imports that I used
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleField extends Application {

    // This is all in the top class, because these objects are used 
    // in 'proccessKeyPress' to handle the Enter key being pressed
    
    // Creates a new TextField 
    // where the user will input the raduis of the circle they want to have
    TextField textField = new TextField();
    
    // Creates a circle template to be manipulated later 
    // when the Enter key is pressed
    Circle circle = new Circle(0, 0, 100);
    
    
    
    // Handles the Stage, Scene, GridpPane with the Circle and TextField 
    @Override
    public void start(Stage primaryStage) {
        
        // GridPane that handles the TextField and the circle
        GridPane inputGrid = new GridPane();
        inputGrid.add(textField, 0, 0);
        inputGrid.add(circle, 0, 0);
        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setStyle("-fx-background-color: white");
        
        // Allows the class that handles the Enter key being pressed,
        // 'proccessKeyPress', to reset the grid, 
        // in turn resetting the radius of the circle
        inputGrid.setOnKeyPressed(this::proccessKeyPress);
        
        // Properties for the circle
        circle.setFill(null);
        circle.setStrokeWidth(5);
        circle.setStroke(Color.BLACK);
        
        // Creates the scene with the GridPane and sets size
        Scene scene = new Scene(inputGrid, 1000, 700);
        
        // Titles the stage and sets other needed start properties
        primaryStage.setTitle("Circle Field");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Handles the Enter key being pressed
    public void proccessKeyPress(KeyEvent event) 
    {
        
       //If the key pressed is the Enter Key it will grab the radius, transform
       // it to a double, set the circles raduis to the inputted radius, 
       // and clear the textField for next input
       switch (event.getCode())
       {
       case ENTER -> {
           double grabbedRadius = Double.parseDouble(textField.getText());
           circle.setRadius(grabbedRadius);
           textField.clear();
            }
       }
    }
    
    // Main class to launch the other classes
    public static void main(String[] args) {
        launch(args);
    }
}
    

    



