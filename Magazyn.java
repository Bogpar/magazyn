/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazyn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ubuntu
 */
public class Magazyn extends Application {
    
    public static void ButtonClicked(ActionEvent e, Stage theStage, Button btn1, Button btn2, Scene scene1, Scene scene2) {
            if (e.getSource() == btn2)
                theStage.setScene(scene1);
            else
                theStage.setScene(scene2);
        }
    
    @Override
    public void start(Stage primaryStage) {
        Stage theStage = primaryStage;
        Button btn1 = new Button();
        Button btn2 = new Button();
   
        btn1.setText("first scene");
        btn2.setText("second scene");
        
        Pane root = new Pane();
        Pane root2 = new Pane();
    
        Scene scene1 = new Scene(root, 1000, 600);
        Scene scene2 = new Scene(root2, 1000, 600);
        
        btn1.setOnAction(e-> ButtonClicked(e, theStage, btn1, btn2, scene1, scene2));
        btn2.setOnAction(e-> ButtonClicked(e, theStage, btn1, btn2, scene1, scene2));
        
        btn1.setLayoutX(0); btn1.setLayoutY(0);
        btn2.setLayoutX(0); btn2.setLayoutY(500);
        
        root.getChildren().add(btn1);
        root2.getChildren().add(btn2);
        
         
        
        primaryStage.setTitle("Magazyn Bona");
        primaryStage.setScene(scene1);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
