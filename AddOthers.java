package magazyn;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static magazyn.Warehouse.otherProducts;

public class AddOthers {
    
    public AddOthers() {}
    
    public void addProductsPage(AnchorPane pane, Stage stage) {
        AddOthers panel = new AddOthers();

        Label productNameTitle = new Label("Nazwa");
        productNameTitle.setLayoutX(50);
        productNameTitle.setLayoutY(55);
        pane.getChildren().add(productNameTitle);
        
        TextField productNameField = new TextField();
        productNameField.setLayoutX(160);
        productNameField.setLayoutY(50);
        pane.getChildren().add(productNameField);
        
        Label uomNameTitle = new Label("JM");
        uomNameTitle.setLayoutX(50);
        uomNameTitle.setLayoutY(105);
        pane.getChildren().add(uomNameTitle);
        
        CheckBox uomCheckBox = new CheckBox("Opakowania");
        uomCheckBox.setLayoutX(160);
        uomCheckBox.setLayoutY(100);
        pane.getChildren().add(uomCheckBox);
        
        CheckBox uomCheckBox2 = new CheckBox("Sztuki");
        uomCheckBox2.setLayoutX(270);
        uomCheckBox2.setLayoutY(100);
        pane.getChildren().add(uomCheckBox2);
        
        Label sizeNameTitle = new Label("Ilość");
        sizeNameTitle.setLayoutX(50);
        sizeNameTitle.setLayoutY(155);
        pane.getChildren().add(sizeNameTitle);
        
        TextField sizeNameField = new TextField();
        sizeNameField.setLayoutX(160);
        sizeNameField.setLayoutY(150);
        pane.getChildren().add(sizeNameField);
        
        Label priceNameTitle = new Label("Cena za szt.");
        priceNameTitle.setLayoutX(50);
        priceNameTitle.setLayoutY(205);
        pane.getChildren().add(priceNameTitle);
        
        TextField priceNameField = new TextField();
        priceNameField.setLayoutX(160);
        priceNameField.setLayoutY(200);
        pane.getChildren().add(priceNameField);
        
        Button submit = new Button();
        submit.setLayoutX(160);
        submit.setLayoutY(250);
        submit.setText("Zatwierdź");
        pane.getChildren().add(submit);
        
        Button clear = new Button();
        clear.setLayoutX(250);
        clear.setLayoutY(250);
        clear.setText("Reset");
        pane.getChildren().add(clear);
        
        clear.setOnAction(e-> panel.clearTheForm(productNameField, uomCheckBox, uomCheckBox2, sizeNameField, priceNameField));
         
        submit.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        if(((uomCheckBox.isSelected() == false) && (uomCheckBox2.isSelected() == false)) || productNameField.getText().trim().equals("") || sizeNameField.getText().trim().equals("") || priceNameField.getText().trim().equals("")) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Błąd przy dodawaniu");
                            alert.setHeaderText("Upewnij się, że wypełniłeś poprawnie formularz");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Dodaj produkt");
                            alert.setHeaderText("Czy jesteś pewien że chcesz dodać ten produkt do magazynu?");

                            Optional <ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {
                               panel.submitTheForm(productNameField, uomCheckBox, uomCheckBox2, sizeNameField, priceNameField); 
                            }
                        }
                }
         });
        
        uomCheckBox.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    uomCheckBox2.setSelected(false);
                }
         });
        uomCheckBox2.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    uomCheckBox.setSelected(false);
                }
         });
    }
    
    public void submitTheForm(TextField productNameField, CheckBox uomCheckBox, CheckBox uomCheckBox2, TextField sizeNameField, TextField priceNameField) {
        Convert convert = new Convert();
        if(!doThisProductExist(productNameField.getText(), uomCheckBox, convert.convertToInt(sizeNameField.getText()), convert.convertToDouble(priceNameField.getText()))) {
            String uomName;
            if(uomCheckBox.isSelected()) {
                uomName = "szt.";
            } else {
                uomName = "opk.";
            }
            if(!uomName.equals("")) {
                otherProducts.add(new OtherProduct(generateProductIdNumber(otherProducts.size()), productNameField.getText(), uomName, convert.convertToInt(sizeNameField.getText()), convert.convertToDouble(priceNameField.getText())));
                Database database = new Database();
                database.writeDataToOtherProducts();
            } else {
                System.out.println("Blad przy dodawaniu AddOthers.java 132");
            }
        } 
    }
    private boolean doThisProductExist(String productName, CheckBox uomCheckBox, int size, double price) {
        boolean toReturn = false;
        String uomName;
        if(uomCheckBox.isSelected()) {
            uomName = "szt.";
        } else {
            uomName = "opk.";
        }
        for(int i = 0; i < otherProducts.size(); i++) {
            if(otherProducts.get(i).getType().equals(productName) && otherProducts.get(i).getUom().equals(uomName) && otherProducts.get(i).getPrice() == price) {
                toReturn = true;
                otherProducts.get(i).addSize(size);
            } 
        }
        return toReturn;
    }
    private int generateProductIdNumber(int arg) {
        int toReturn = arg-1;
            do {
                    toReturn++;
            } while(doThisIdExist(toReturn));
	return toReturn;
    }
    
    private boolean doThisIdExist(int arg) {
        for(int i = 0; i < otherProducts.size(); i++) {
                if(otherProducts.get(i).getId() == arg) {
                        return true;
                }
        }
        return false;
    }
    
    private void clearTheForm(TextField productNameField, CheckBox uomCheckBox, CheckBox uomCheckBox2, TextField sizeNameField, TextField priceNameField) {
        productNameField.setText("");
        uomCheckBox.setSelected(false);
        uomCheckBox2.setSelected(false);
        sizeNameField.setText("");
        priceNameField.setText("");
    }
}
