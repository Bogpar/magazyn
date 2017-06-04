package magazyn;

import java.util.*;
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

public class Warehouse extends Application {
    static ArrayList<Product> products = new ArrayList<Product>();
   
    private void setOfProductsPage(AnchorPane pane) {
        Button ref = new Button();
        Warehouse magazyn = new Warehouse();
        
        ref.setText("Odśwież");
        ref.setLayoutX(50);
        ref.setLayoutY(300);
        ref.setOnAction(e-> magazyn.refThePage(e, pane));
        
        /*String fill = "";
        for(int i = 0; i<products.size(); i++) {
            fill = "Rodzaj: " + products.get(i).getType() + " Rozmiar: " + products.get(i).getSize() + "m2 Cena za m2: " + products.get(i).getPrice() + " zł\n";
        }
        Label listOfProducts = new Label(fill);
        pane.getChildren().add(listOfProducts);*/
        pane.getChildren().add(ref);
    }
    
    private void refThePage(ActionEvent e, AnchorPane pane) {
        String fill = "";
        for(int i = 0; i < products.size(); i++) {
            fill += "Rodzaj: " + products.get(i).getType() + " Rozmiar: " + products.get(i).getSize() + "m2 Cena za m2: " + products.get(i).getPrice() + " zł" + System.lineSeparator();
        }
        Label listOfProducts = new Label(fill);
            listOfProducts.setLayoutX(50);
            listOfProducts.setLayoutY(55);
        pane.getChildren().add(listOfProducts);
    }
    
    private void addProductsPage(AnchorPane pane) {
        Warehouse magazyn = new Warehouse();
        //Nazwa produktu
        Label productNameTitle = new Label("Rodzaj");
        productNameTitle.setLayoutX(50);
        productNameTitle.setLayoutY(55);
        pane.getChildren().add(productNameTitle);
        
        TextField productNameField = new TextField();
        productNameField.setLayoutX(160);
        productNameField.setLayoutY(50);
        pane.getChildren().add(productNameField);
        
        //Ilość
        Label sizeNameTitle = new Label("Rozmiar");
        sizeNameTitle.setLayoutX(50);
        sizeNameTitle.setLayoutY(105);
        pane.getChildren().add(sizeNameTitle);
        
        TextField sizeNameField = new TextField();
        sizeNameField.setLayoutX(160);
        sizeNameField.setLayoutY(100);
        pane.getChildren().add(sizeNameField);
        
        //Cena
        Label priceNameTitle = new Label("Cena za m2");
        priceNameTitle.setLayoutX(50);
        priceNameTitle.setLayoutY(155);
        pane.getChildren().add(priceNameTitle);
        
        TextField priceNameField = new TextField();
        priceNameField.setLayoutX(160);
        priceNameField.setLayoutY(150);
        pane.getChildren().add(priceNameField);
        
        Button submit = new Button();
        submit.setLayoutX(160);
        submit.setLayoutY(200);
        submit.setText("Zatwierdź");
        pane.getChildren().add(submit);
        
        Button clear = new Button();
        clear.setLayoutX(250);
        clear.setLayoutY(200);
        clear.setText("Reset");
        pane.getChildren().add(clear);
        
        submit.setOnAction(e-> magazyn.submitTheForm(e, productNameField, sizeNameField, priceNameField));
        clear.setOnAction(e-> magazyn.clearTheForm(e, productNameField, sizeNameField, priceNameField));
        

    }
    
    private void submitTheForm(ActionEvent e, TextField productNameField, TextField sizeNameField, TextField priceNameField) {
        if(productNameField.getText().trim().equals("") && sizeNameField.getText().trim().equals("") && priceNameField.getText().trim().equals("")) {
            System.out.println("Błąd");
        } else {
            Convert convert = new Convert();
            System.out.println(products.size());
            products.add(products.size(), new Product(generateProductIdNumber(products.size()),productNameField.getText(), convert.convertToInt(sizeNameField.getText()), convert.convertToDouble(priceNameField.getText())));
            System.out.println("Sukces");
            System.out.println(products.size());
        }
    }
    
    private int generateProductIdNumber(int arg) {
        int toReturn = arg-1;
            do {
                    toReturn++;
            } while(doThisProductExist(toReturn));
	return toReturn;
    }
    
    private boolean doThisProductExist(int arg) {
        for(int i = 0; i < products.size(); i++) {
                if(products.get(i).getId() == arg) {
                        return true;
                }
        }
        return false;
    }
    
    private void clearTheForm(ActionEvent e, TextField productNameField, TextField sizeNameField, TextField priceNameField) {
        productNameField.setText("");
        sizeNameField.setText("");
        priceNameField.setText("");
    }
    
    @Override
    public void start(Stage primaryStage) {
        Warehouse magazyn = new Warehouse();
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
        /*Button btn1 = new Button();
        Button btn2 = new Button();
        
        btn1.setText("1 scene");
        btn2.setText("2 scene");
        
        btn1.setLayoutX(400); 
        btn1.setLayoutY(200);
        
        btn2.setLayoutX(400); 
        btn2.setLayoutY(200);
        
        pane1.getChildren().add(btn1);
        pane2.getChildren().add(btn2);*/
        
        magazyn.setOfProductsPage(pane1);
        magazyn.addProductsPage(pane4);
        
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
