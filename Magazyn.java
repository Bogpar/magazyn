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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
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
    
    public void addProductsForm(AnchorPane pane4) {
        Magazyn magazyn = new Magazyn();
        //Nazwa produktu
        Label productNameTitle = new Label("Rodzaj");
        productNameTitle.setLayoutX(50);
        productNameTitle.setLayoutY(55);
        pane4.getChildren().add(productNameTitle);
        
        TextField productNameField = new TextField();
        productNameField.setLayoutX(160);
        productNameField.setLayoutY(50);
        pane4.getChildren().add(productNameField);
        
        //Ilość
        Label sizeNameTitle = new Label("Rozmiar");
        sizeNameTitle.setLayoutX(50);
        sizeNameTitle.setLayoutY(105);
        pane4.getChildren().add(sizeNameTitle);
        
        TextField sizeNameField = new TextField();
        sizeNameField.setLayoutX(160);
        sizeNameField.setLayoutY(100);
        pane4.getChildren().add(sizeNameField);
        
        //Cena
        Label priceNameTitle = new Label("Cena za m2");
        priceNameTitle.setLayoutX(50);
        priceNameTitle.setLayoutY(155);
        pane4.getChildren().add(priceNameTitle);
        
        TextField priceNameField = new TextField();
        priceNameField.setLayoutX(160);
        priceNameField.setLayoutY(150);
        pane4.getChildren().add(priceNameField);
        
        Button submit = new Button();
        submit.setLayoutX(160);
        submit.setLayoutY(200);
        submit.setText("Zatwierdź");
        pane4.getChildren().add(submit);
        
        Button clear = new Button();
        clear.setLayoutX(250);
        clear.setLayoutY(200);
        clear.setText("Reset");
        pane4.getChildren().add(clear);
        
        submit.setOnAction(e-> magazyn.submitTheForm(e, productNameField, sizeNameField, priceNameField));
        clear.setOnAction(e-> magazyn.clearTheForm(e, productNameField, sizeNameField, priceNameField));
        

    }
    
    public void submitTheForm(ActionEvent e, TextField productNameField, TextField sizeNameField, TextField priceNameField) {
        if(productNameField.getText().trim().equals("") && sizeNameField.getText().trim().equals("") && priceNameField.getText().trim().equals("")) {
            //tworzymy obiekt
        } else {
            //lipa
        }
    
    }
    
    public void clearTheForm(ActionEvent e, TextField productNameField, TextField sizeNameField, TextField priceNameField) {
        productNameField.setText("");
        sizeNameField.setText("");
        priceNameField.setText("");
    }
    
    @Override
    public void start(Stage primaryStage) {
        Magazyn magazyn = new Magazyn();
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
        MenuItem underMenu5 = new MenuItem("Dodaj materiał do magazynu");
        MenuItem underMenu6 = new MenuItem("Usuń z magazynu");
        
        menu4.getItems().addAll(underMenu5, underMenu6);
        
        
        MenuBar menuBar = new MenuBar();

        
        menuBar.getMenus().addAll(menu1, menu2, menu3, menu4);

        
        
        
        BorderPane root = new BorderPane();
        
        AnchorPane pane1 = new AnchorPane();
        AnchorPane pane2 = new AnchorPane();
        AnchorPane pane3 = new AnchorPane();
        AnchorPane pane4 = new AnchorPane();
        
        
        underMenu1.setOnAction(e -> root.setCenter(pane1));
        underMenu2.setOnAction(e -> root.setCenter(pane2));
        underMenu3.setOnAction(e -> root.setCenter(pane2));
        underMenu4.setOnAction(e -> root.setCenter(pane3));
        underMenu5.setOnAction(e -> root.setCenter(pane4));
        underMenu6.setOnAction(e -> root.setCenter(pane4));
        

    
        Scene scene = new Scene(root, 1000, 600);

        //btn1.setOnAction(e-> ButtonClicked(e, primaryStage, btn1, btn2, scene1, scene2));
       
        //underMenu1.setOnAction(e-> MenuClicked(e, theStage, scene));
        
   
        

        Text magazynTitle = new Text (10, 20, "Magazyn zasobów");
        pane1.getChildren().add(magazynTitle);
        Text productionTitle = new Text (10, 20, "Produkcja");
        pane2.getChildren().add(productionTitle);
        Text paymentTitle = new Text (10, 20, "Płatności i koszty");
        pane3.getChildren().add(paymentTitle);
        Text adminSiteTitle = new Text (10, 20, "Panel Administracyjny");
        pane4.getChildren().add(adminSiteTitle);
        
        
        //Przyciski
        Button btn1 = new Button();
        Button btn2 = new Button();
        
        btn1.setText("1 scene");
        btn2.setText("2 scene");
        
        btn1.setLayoutX(400); 
        btn1.setLayoutY(200);
        
        btn2.setLayoutX(400); 
        btn2.setLayoutY(200);
        
        pane1.getChildren().add(btn1);
        pane2.getChildren().add(btn2);
        
        magazyn.addProductsForm(pane4);
        
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
