package magazyn;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static magazyn.Warehouse.history;
import static magazyn.Warehouse.otherProducts;
import static magazyn.Warehouse.products;

public class Production {
    
    public void productionPanel(AnchorPane pane) {
        Production panel = new Production();
        
        Label nameTitle = new Label("Nazwa");
        nameTitle.setLayoutX(50);
        nameTitle.setLayoutY(55);
        pane.getChildren().add(nameTitle);
        
        TextField nameField = new TextField();
        nameField.setLayoutX(160);
        nameField.setLayoutY(50);
        pane.getChildren().add(nameField);
        
        Label productNameTitle = new Label("Materiał");
        productNameTitle.setLayoutX(50);
        productNameTitle.setLayoutY(105);
        pane.getChildren().add(productNameTitle);
        
        TextField productNameField = new TextField();
        productNameField.setLayoutX(160);
        productNameField.setLayoutY(100);
        pane.getChildren().add(productNameField);
        
        Label sizeNameTitle = new Label("Rozmiar w \u33A1");
        sizeNameTitle.setLayoutX(50);
        sizeNameTitle.setLayoutY(155);
        pane.getChildren().add(sizeNameTitle);
        
        TextField sizeNameField = new TextField();
        sizeNameField.setLayoutX(160);
        sizeNameField.setLayoutY(150);
        pane.getChildren().add(sizeNameField);
        
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
        
        clear.setOnAction(e-> panel.clearTheForm(nameField, productNameField, sizeNameField));
        
        submit.setOnAction(
                new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Convert convert = new Convert();
                    if(nameField.getText().trim().equals("") || productNameField.getText().trim().equals("") || sizeNameField.getText().trim().equals("")) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Produkcja - błąd");
                        alert.setHeaderText("Źle wypełniony formularz");
                        alert.showAndWait();
                    } else {
                        if((products.size() > 0) && otherProducts.size() > 0) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Produkcja");
                            alert.setHeaderText("Czy jesteś pewien że chcesz wyprodukować? to usunie zasoby z magazynu");

                            Optional <ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {
                               panel.performTheProduction(nameField, productNameField, sizeNameField); 
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Produkcja - błąd");
                            alert.setHeaderText("Brak zasobów w magazynie");
                            alert.showAndWait();
                        }
                    }
                }
            });
        
    }
    
    public void clearTheForm(TextField nameField, TextField productNameField, TextField sizeNameField) {
        nameField.setText("");
        productNameField.setText("");
        sizeNameField.setText("");
    }
    public void performTheProduction(TextField nameField, TextField productNameField, TextField sizeNameField) {
        Convert convert = new Convert();
        for(int i = 0; i < products.size(); i++) {
            
            if(products.get(i).getType().equals(productNameField.getText())) {
                double result = products.get(i).getSize() - convert.convertToDouble(sizeNameField.getText());
                double value = convert.convertToDouble(sizeNameField.getText());
                if(result >= 0) {
                    products.get(i).setSize(result);
                    double price = products.get(i).getPrice() * value;
                    history.add(new History("Wyprodukowano towar za pomocą materiału " + products.get(i).getType() + " wykorzystano " + value + " \u33A1 materiału co kosztowało " + price  + " zł"));
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Produkcja - błąd");
                    alert.setHeaderText("Materiał jest, ale jest go za mało");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Produkcja - błąd");
                alert.setHeaderText("Brak materiału w magazynie");
                alert.showAndWait();
            }
        }
    }
}
