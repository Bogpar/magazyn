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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author ubuntu
 */
public class Magazyn extends Application {
    
   /* public static void ButtonClicked(ActionEvent e, Stage theStage, Button btn1, Button btn2, Scene scene1, Scene scene2) {
            if (e.getSource() == btn2)
                theStage.setScene(scene1);
            else
                theStage.setScene(scene2);
    }*/
    
    public static void MenuClicked(ActionEvent e, Stage theStage, Scene scene) {
                theStage.setScene(scene);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage theStage = primaryStage;
        Menu menu1 = new Menu("Magazyn");
        Menu menu2 = new Menu("Produkcja");
        Menu menu3 = new Menu("Płatności");
        Menu menu4 = new Menu("Panel");
        //Magazyn
        MenuItem underMenu1 = new MenuItem("Sprawdź aktualny stan magazynu");
        menu1.getItems().addAll(underMenu1);
        
        //Produkcja
        MenuItem underMenu2 = new MenuItem("Wyprodukuj");
        MenuItem underMenu3 = new MenuItem("Sprawdź historię produkcji");
        
        menu2.getItems().addAll(underMenu2, underMenu3);
        
        //Płatności
        MenuItem underMenu4 = new MenuItem("Sprawdź płatności");
        
        menu3.getItems().addAll(underMenu4);
        
        //Panel
        MenuItem underMenu5 = new MenuItem("Dodaj do magazynu");
        MenuItem underMenu6 = new MenuItem("Usuń z magazynu");
        
        menu4.getItems().addAll(underMenu5, underMenu6);
        
        
        MenuBar menuBar = new MenuBar();

        
        menuBar.getMenus().addAll(menu1, menu2, menu3, menu4);

        
        //Przyciski
        Button btn1 = new Button();
        Button btn2 = new Button();
       // Button btn3 = new Button();
       // Button btn4 = new Button();
        
        btn1.setText("1 scene");
        btn2.setText("2 scene");
      //  btn3.setText("3 scene");
       // btn4.setText("4 scene");
        
        BorderPane root = new BorderPane();
        
        AnchorPane pane1 = new AnchorPane();
        AnchorPane pane2 = new AnchorPane();
        
        underMenu1.setOnAction(e -> root.setCenter(pane1));
        underMenu2.setOnAction(e -> root.setCenter(pane2));

    
        Scene scene = new Scene(root, 1000, 600);

        //btn1.setOnAction(e-> ButtonClicked(e, primaryStage, btn1, btn2, scene1, scene2));
       
        //underMenu1.setOnAction(e-> MenuClicked(e, theStage, scene));
        
   
        btn1.setLayoutX(400); 
        btn1.setLayoutY(200);
        
        btn2.setLayoutX(400); 
        btn2.setLayoutY(200);
        
       // btn3.setLayoutX(400); 
       // btn3.setLayoutY(200);
        
       // btn4.setLayoutX(400); 
       // btn4.setLayoutY(200);
        
        pane1.getChildren().add(btn1);
        pane2.getChildren().add(btn2);

        
        root.setTop(menuBar);
        root.setCenter(pane1);
        
        
        primaryStage.setTitle("Magazyn Bona");
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
