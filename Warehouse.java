package magazyn;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Warehouse extends Application {
    static ObservableList<Product> products = FXCollections.observableArrayList();
    static ObservableList<OtherProduct> otherProducts = FXCollections.observableArrayList();
    static ObservableList<History> history = FXCollections.observableArrayList();
    
    ArrayList<Product> productList = new ArrayList();
    ArrayList<Product> otherList = new ArrayList();
    ArrayList<Product> historyList = new ArrayList();

    public Warehouse() {}
   
    @Override
    public void start(Stage primaryStage) {
        Warehouse magazyn = new Warehouse();
        Stage theStage = primaryStage;
        
        init();
        
        //Setup menu
        Menu menu1 = new Menu("Magazyn");
        Menu menu2 = new Menu("Produkcja");
        Menu menu3 = new Menu("Historia");
        Menu menu4 = new Menu("Panel");
        //Magazyn
        MenuItem underMenu1 = new MenuItem("Sprawdź aktualny stan magazynu");
        menu1.getItems().addAll(underMenu1);
        
        //Produkcja
        MenuItem underMenu2 = new MenuItem("Wyprodukuj");
        
        menu2.getItems().addAll(underMenu2);
        
        //Płatności
        MenuItem underMenu4 = new MenuItem("Sprawdź historie");
        menu3.getItems().addAll(underMenu4);
        
        //Panel
        MenuItem underMenu5 = new MenuItem("Dodaj materiał do magazynu");
        MenuItem underMenu6 = new MenuItem("Dodaj inne do magazynu");
        MenuItem underMenu7 = new MenuItem("Usuń z magazynu materiał");
        MenuItem underMenu8 = new MenuItem("Usuń z magazynu przedmiot");
        
        menu4.getItems().addAll(underMenu5, underMenu6, underMenu7, underMenu8);
        
        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().addAll(menu1, menu2, menu3, menu4);

        BorderPane root = new BorderPane();
        
        AnchorPane pane1 = new AnchorPane();
        AnchorPane pane2 = new AnchorPane();
        AnchorPane pane3 = new AnchorPane();
        AnchorPane pane4 = new AnchorPane();
        AnchorPane pane5 = new AnchorPane();
        AnchorPane pane6 = new AnchorPane();
        AnchorPane pane7 = new AnchorPane();
        
        underMenu1.setOnAction(e -> root.setCenter(pane1));
        underMenu2.setOnAction(e -> root.setCenter(pane2));
        //underMenu3.setOnAction(e -> root.setCenter(pane2));
        underMenu4.setOnAction(e -> root.setCenter(pane3));
        underMenu5.setOnAction(e -> root.setCenter(pane4));
        underMenu6.setOnAction(e -> root.setCenter(pane5));
        underMenu7.setOnAction(e -> root.setCenter(pane6));
        underMenu8.setOnAction(e -> root.setCenter(pane7));
    
    //Setup pages  
        Scene scene = new Scene(root, 1000, 600);
        
        Text magazynTitle = new Text (10, 20, "Magazyn zasobów");
        pane1.getChildren().add(magazynTitle);
        Text productionTitle = new Text (10, 20, "Produkcja");
        pane2.getChildren().add(productionTitle);
        Text paymentTitle = new Text (10, 20, "Historia");
        pane3.getChildren().add(paymentTitle);
        Text adminSiteTitle = new Text (10, 20, "Panel Administracyjny - dodaj materiał");
        pane4.getChildren().add(adminSiteTitle);
        Text adminSiteTitle2 = new Text (10, 20, "Panel Administracyjny - dodaj inne");
        pane5.getChildren().add(adminSiteTitle2);
        Text adminSiteTitle3 = new Text (10, 20, "Panel Administracyjny - usuń materiał");
        pane6.getChildren().add(adminSiteTitle3);
        Text adminSiteTitle4 = new Text (10, 20, "Panel Administracyjny - usuń przedmiot");
        pane7.getChildren().add(adminSiteTitle4);
        
        Overview overview = new Overview();
        overview.setOfProductsPage(pane1); //Magazyn rozpiska
        
        HistoryPanel historySec = new HistoryPanel();
        historySec.historyOverview(pane3);
        
        AddMaterials panel = new AddMaterials();
        panel.addProductsPage(pane4, theStage); //Panel administratora
        
        AddOthers others = new AddOthers();
        others.addProductsPage(pane5, theStage);
        
        panel.removeProductsPage(pane6);
        others.removeProductsPage(pane7);
        
        root.setTop(menuBar);
        root.setCenter(pane1);
        
        primaryStage.setTitle("System zarządzania produkcją firmy BONA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void init() {
        Database database = new Database();
        database.readDataFromProducts();
        database.readDataFromOtherProducts();
        database.readDataFromHistory();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
