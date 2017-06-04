package magazyn;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static magazyn.Warehouse.products;

public class Panel {
    public void addProductsPage(AnchorPane pane) {
        Panel panel = new Panel();
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
        
        submit.setOnAction(e-> panel.submitTheForm(e, productNameField, sizeNameField, priceNameField));
        clear.setOnAction(e-> panel.clearTheForm(e, productNameField, sizeNameField, priceNameField));
        

    }
    
    public void submitTheForm(ActionEvent e, TextField productNameField, TextField sizeNameField, TextField priceNameField) {
        if(productNameField.getText().trim().equals("") && sizeNameField.getText().trim().equals("") && priceNameField.getText().trim().equals("")) {
            System.out.println("Błąd");
        } else {
            Convert convert = new Convert();
            System.out.println(products.size());

            if(!doThisProductExist(productNameField.getText(), convert.convertToInt(sizeNameField.getText()), convert.convertToDouble(priceNameField.getText()))) {
                products.add(new Product(generateProductIdNumber(products.size()),productNameField.getText(), convert.convertToInt(sizeNameField.getText()), convert.convertToDouble(priceNameField.getText())));
                System.out.println(products.get(products.size()-1).getType());
                System.out.println(products.size());
            }
        }
    }
    private boolean doThisProductExist(String productName, int size, double price) {
        boolean toReturn = false;
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getType().equals(productName) && products.get(i).getSize() == size && products.get(i).getPrice() == price) {
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
    
    public void clearTheForm(ActionEvent e, TextField productNameField, TextField sizeNameField, TextField priceNameField) {
        productNameField.setText("");
        sizeNameField.setText("");
        priceNameField.setText("");
    }
}
