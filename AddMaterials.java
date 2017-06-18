package magazyn;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static magazyn.Warehouse.products;

public class AddMaterials {
    public void addProductsPage(AnchorPane pane, Stage stage) {
        AddMaterials panel = new AddMaterials();
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
        Label sizeNameTitle = new Label("Rozmiar w \u33A1");
        sizeNameTitle.setLayoutX(50);
        sizeNameTitle.setLayoutY(105);
        pane.getChildren().add(sizeNameTitle);
        
        TextField sizeNameField = new TextField();
        sizeNameField.setLayoutX(160);
        sizeNameField.setLayoutY(100);
        pane.getChildren().add(sizeNameField);
        
        //Cena
        Label priceNameTitle = new Label("Cena za \u33A1");
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
        
        
        clear.setOnAction(e-> panel.clearTheForm(e, productNameField, sizeNameField, priceNameField));

        submit.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        if(productNameField.getText().trim().equals("") || sizeNameField.getText().trim().equals("") || priceNameField.getText().trim().equals("")) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Błąd przy dodawaniu konta");
                            alert.setHeaderText("Upewnij się, że wypełniłeś poprawnie formularz");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Dodaj produkt");
                            alert.setHeaderText("Czy jesteś pewien że chcesz dodać ten produkt do magazynu?");

                            Optional <ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {
                               panel.submitTheForm(productNameField, sizeNameField, priceNameField); 
                            }
                        }
                }
         });
    }
    
    public void removeProductsPage(AnchorPane pane) {
        AddMaterials panel = new AddMaterials();
        Label productIdTitle = new Label("Id");
        productIdTitle.setLayoutX(50);
        productIdTitle.setLayoutY(55);
        pane.getChildren().add(productIdTitle);
        
        TextField idField = new TextField();
        idField.setLayoutX(160);
        idField.setLayoutY(50);
        pane.getChildren().add(idField);
        
        Button submit = new Button();
        submit.setLayoutX(160);
        submit.setLayoutY(200);
        submit.setText("Zatwierdź");
        pane.getChildren().add(submit);
        
        submit.setOnAction(e-> panel.deleteTheProduct(idField));
    }
    
    public void deleteTheProduct(TextField idField) {
        if(idField.getText().trim().equals("") && doThisIdExist(Integer.parseInt(idField.getText())) ) {
            System.out.println("Blad usuniecia konta o numerze " + idField.getText());
        } else {
            products.remove(Integer.parseInt(idField.getText()));
        }
    }
    
    public void submitTheForm(TextField productNameField, TextField sizeNameField, TextField priceNameField) {
        Convert convert = new Convert();
        if(!doThisProductExist(productNameField.getText(), convert.convertToInt(sizeNameField.getText()), convert.convertToDouble(priceNameField.getText()))) {
            products.add(new Product(generateProductIdNumber(products.size()),productNameField.getText(), convert.convertToDouble(sizeNameField.getText()), convert.convertToDouble(priceNameField.getText())));
        } 
    }
    private boolean doThisProductExist(String productName, double size, double price) {
        boolean toReturn = false;
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getType().equals(productName) && products.get(i).getPrice() == price) {
                toReturn = true;
                products.get(i).addSize(size);
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
        for(int i = 0; i < products.size(); i++) {
                if(products.get(i).getId() == arg) {
                        return true;
                }
        }
        return false;
    }
    
    void clearTheForm(ActionEvent e, TextField productNameField, TextField sizeNameField, TextField priceNameField) {
        productNameField.setText("");
        sizeNameField.setText("");
        priceNameField.setText("");
    }
}
