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
       typeCol.setMinWidth(300);
       typeCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("type"));
       TableColumn sizeCol = new TableColumn("Rozmiar (\u33A1)");
       sizeCol.setMinWidth(300);
       sizeCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("size"));
       TableColumn priceCol = new TableColumn("Cena (zł/\u33A1)");
       priceCol.setMinWidth(300);
       priceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("price"));
       table.setItems(products);
       table.getColumns().addAll(idCol, typeCol, sizeCol, priceCol);
        pane.getChildren().add(table);
    }
}
