package magazyn;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static magazyn.Warehouse.otherProducts;
import static magazyn.Warehouse.products;

public class Overview {
    public void setOfProductsPage(AnchorPane pane) {
       TableView table = new TableView();
       TableView table2 = new TableView(); 
       
       table.setEditable(true);
       table.setMinWidth(1000);
       table.setMinHeight(300);
       TableColumn idCol = new TableColumn("Id");
       idCol.setMinWidth(100);
       idCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("id"));
       TableColumn typeCol = new TableColumn("Nazwa");
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
       
       table2.setEditable(true);
       table2.setMinWidth(1000);
       table2.setMinHeight(300);
       table2.setLayoutY(300);
       
       TableColumn idC = new TableColumn("Id");
       idC.setMinWidth(100);
       idC.setCellValueFactory(
                new PropertyValueFactory<Product, String>("id"));
       TableColumn typeC = new TableColumn("Nazwa");
       typeC.setMinWidth(225);
       typeC.setCellValueFactory(
                new PropertyValueFactory<Product, String>("type"));
       TableColumn uomC = new TableColumn("Jednoska Miary");
       uomC.setMinWidth(225);
       uomC.setCellValueFactory(
                new PropertyValueFactory<Product, String>("uom"));
       TableColumn amountC = new TableColumn("Ilość");
       amountC.setMinWidth(225);
       amountC.setCellValueFactory(
                new PropertyValueFactory<Product, String>("size"));
       TableColumn priceC = new TableColumn("Cena");
       priceC.setMinWidth(225);
       priceC.setCellValueFactory(
                new PropertyValueFactory<Product, String>("price"));
       
       table.setItems(products);
       table2.setItems(otherProducts);
       table.getColumns().addAll(idCol, typeCol, sizeCol, priceCol);
       table2.getColumns().addAll(idC, typeC, uomC, amountC, priceC);
       pane.getChildren().add(table);
       pane.getChildren().add(table2);
       
       
       
    }
}
