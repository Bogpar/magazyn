    package magazyn;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static magazyn.Warehouse.products;

public class Overview {
    public void setOfProductsPage(AnchorPane pane) {
       TableView table = new TableView();
        
       table.setEditable(true);
       table.setMinWidth(1000);
       table.setMinHeight(600);
       TableColumn idCol = new TableColumn("Id");
       idCol.setMinWidth(100);
       idCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("id"));
       TableColumn typeCol = new TableColumn("Rodzaj");
       typeCol.setMinWidth(180);
       typeCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("type"));
       TableColumn widthCol = new TableColumn("Szerokość (cm)");
       widthCol.setMinWidth(180);
       widthCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("width"));
       TableColumn heightCol = new TableColumn("Wysokość (cm)");
       heightCol.setMinWidth(180);
       heightCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("height"));
       TableColumn sizeCol = new TableColumn("Rozmiar (\u33A1)");
       sizeCol.setMinWidth(180);
       sizeCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("size"));
       TableColumn priceCol = new TableColumn("Cena (zł/\u33A1)");
       priceCol.setMinWidth(180);
       priceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("price"));
       table.setItems(products);
       table.getColumns().addAll(idCol, typeCol, widthCol, heightCol, sizeCol, priceCol);
       pane.getChildren().add(table);
    }
}
