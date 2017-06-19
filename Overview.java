package magazyn;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import static magazyn.Warehouse.otherProducts;
import static magazyn.Warehouse.products;

public class Overview {
    
    public void setOfProductsPage(AnchorPane pane) {
       TableView table = new TableView();
       TableView table2 = new TableView(); 
       
       table.setEditable(true);
       table.setMinWidth(1000);
       table.setMinHeight(250);
       table.setLayoutY(50);
       TableColumn idCol = new TableColumn("Id");
       idCol.setMinWidth(100);
       idCol.setCellValueFactory(
                new PropertyValueFactory<Product, Integer>("id"));
       TableColumn typeCol = new TableColumn("Nazwa");
       typeCol.setMinWidth(300);
       typeCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("type"));
       typeCol.setCellFactory(TextFieldTableCell.forTableColumn());
       typeCol.setOnEditCommit( new EventHandler<CellEditEvent<Product, String>>() {
            @Override
            public void handle(CellEditEvent<Product, String> t) {
                    ((Product) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setType(t.getNewValue());
                }
            }
        );
       
       TableColumn sizeCol = new TableColumn("Rozmiar (\u33A1)");
       sizeCol.setMinWidth(300);
       sizeCol.setCellValueFactory(
                new PropertyValueFactory<Product, Double>("size"));
       sizeCol.setCellFactory(TextFieldTableCell.<Product, Double>forTableColumn(new DoubleStringConverter()));
       sizeCol.setOnEditCommit( new EventHandler<CellEditEvent<Product, Double>>() {
            @Override
            public void handle(CellEditEvent<Product, Double> t) {
                    ((Product) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setSize(t.getNewValue());
                }
            }
        );
       
       TableColumn priceCol = new TableColumn("Cena (zł/\u33A1)");
       priceCol.setMinWidth(300);
       priceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("price"));
       priceCol.setCellFactory(TextFieldTableCell.<Product, Double>forTableColumn(new DoubleStringConverter()));
       priceCol.setOnEditCommit( new EventHandler<CellEditEvent<Product, Double>>() {
            @Override
            public void handle(CellEditEvent<Product, Double> t) {
                    ((Product) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setPrice(t.getNewValue());
                    
                }
            }
        );
       
       table2.setEditable(true);
       table2.setMinWidth(1000);
       table2.setMinHeight(300);
       table2.setLayoutY(300);
       
       TableColumn idC = new TableColumn("Id");
       idC.setMinWidth(100);
       idC.setCellValueFactory(
                new PropertyValueFactory<OtherProduct, Integer>("id"));
       TableColumn typeC = new TableColumn("Nazwa");
       typeC.setMinWidth(225);
       typeC.setCellValueFactory(
                new PropertyValueFactory<OtherProduct, String>("type"));
       typeC.setCellFactory(TextFieldTableCell.forTableColumn());
       typeC.setOnEditCommit( new EventHandler<CellEditEvent<OtherProduct, String>>() {
            @Override
            public void handle(CellEditEvent<OtherProduct, String> t) {
                    ((OtherProduct) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setType(t.getNewValue());
                }
            }
        );
       TableColumn uomC = new TableColumn("Jednoska Miary");
       uomC.setMinWidth(225);
       uomC.setCellValueFactory(
                new PropertyValueFactory<OtherProduct, String>("uom"));
       TableColumn amountC = new TableColumn("Ilość");
       amountC.setMinWidth(225);
       amountC.setCellValueFactory(
                new PropertyValueFactory<OtherProduct, Integer>("size"));
       amountC.setCellFactory(TextFieldTableCell.<OtherProduct, Integer>forTableColumn(new IntegerStringConverter()));
       amountC.setOnEditCommit( new EventHandler<CellEditEvent<OtherProduct, Integer>>() {
            @Override
            public void handle(CellEditEvent<OtherProduct, Integer> t) {
                    ((OtherProduct) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setSize(t.getNewValue());
                    
                }
            }
        );
       TableColumn priceC = new TableColumn("Cena");
       priceC.setMinWidth(225);
       priceC.setCellValueFactory(
                new PropertyValueFactory<OtherProduct, Double>("price"));
       priceC.setCellFactory(TextFieldTableCell.<OtherProduct, Double>forTableColumn(new DoubleStringConverter()));
       priceC.setOnEditCommit( new EventHandler<CellEditEvent<OtherProduct, Double>>() {
            @Override
            public void handle(CellEditEvent<OtherProduct, Double> t) {
                    ((OtherProduct) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setPrice(t.getNewValue());
                    
                }
            }
        );
       
       Button refresh = new Button();
       refresh.setLayoutX(300);
       refresh.setLayoutY(15);
       refresh.setText("Odśwież");
       pane.getChildren().add(refresh);
        
       refresh.setOnAction( new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) { 
                    table.refresh();
                    table2.refresh();
                }
         });
       
       table.setItems(products);
       table2.setItems(otherProducts);
       table.getColumns().addAll(idCol, typeCol, sizeCol, priceCol);
       table2.getColumns().addAll(idC, typeC, uomC, amountC, priceC);
       pane.getChildren().add(table);
       pane.getChildren().add(table2);
       
       
       
    }
}
