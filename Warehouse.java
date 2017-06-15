package magazyn;

import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Warehouse extends Application {
    static ObservableList<Product> products = FXCollections.observableArrayList(
            new Product(0,"weqwe",140,1000,123)
    );

    @Override
    public void start(Stage primaryStage) {
        Warehouse magazyn = new Warehouse();
        Stage theStage = primaryStage;
        
    //Setup menu
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
        AnchorPane pane5 = new AnchorPane();
        
        underMenu1.setOnAction(e -> root.setCenter(pane1));
        underMenu2.setOnAction(e -> root.setCenter(pane2));
        underMenu3.setOnAction(e -> root.setCenter(pane2));
        underMenu4.setOnAction(e -> root.setCenter(pane3));
        underMenu5.setOnAction(e -> root.setCenter(pane4));
        underMenu6.setOnAction(e -> root.setCenter(pane5));
    
    //Setup pages  
        Scene scene = new Scene(root, 1000, 600);
        
        Text magazynTitle = new Text (10, 20, "Magazyn zasobów");
        pane1.getChildren().add(magazynTitle);
        Text productionTitle = new Text (10, 20, "Produkcja");
        pane2.getChildren().add(productionTitle);
        Text paymentTitle = new Text (10, 20, "Płatności i koszty");
        pane3.getChildren().add(paymentTitle);
        Text adminSiteTitle = new Text (10, 20, "Panel Administracyjny");
        pane4.getChildren().add(adminSiteTitle);
        
        Overview overview = new Overview();
        overview.setOfProductsPage(pane1); //Magazyn rozpiska
        
        Panel panel = new Panel();
        panel.addProductsPage(pane4, theStage); //Panel administratora
        panel.removeProductsPage(pane5);
        
        root.setTop(menuBar);
        root.setCenter(pane1);
        
        primaryStage.setTitle("System zarządzania produkcją firmy BONA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
