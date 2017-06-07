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
        Label widthNameTitle = new Label("Szerokość w cm");
        widthNameTitle.setLayoutX(50);
        widthNameTitle.setLayoutY(105);
        pane.getChildren().add(widthNameTitle);
        
        TextField widthNameField = new TextField();
        widthNameField.setLayoutX(160);
        widthNameField.setLayoutY(100);
        pane.getChildren().add(widthNameField);
        
        Label heightNameTitle = new Label("Wysokość w cm");
        heightNameTitle.setLayoutX(50);
        heightNameTitle.setLayoutY(155);
        pane.getChildren().add(heightNameTitle);
        
        TextField heightNameField = new TextField();
        heightNameField.setLayoutX(160);
        heightNameField.setLayoutY(150);
        pane.getChildren().add(heightNameField);
        
        //Cena
        Label priceNameTitle = new Label("Cena za \u33A1");
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
        
        submit.setOnAction(e-> panel.submitTheForm(e, productNameField, widthNameField, heightNameField, priceNameField));
        clear.setOnAction(e-> panel.clearTheForm(e, productNameField, widthNameField, heightNameField, priceNameField));
        
    }
    
    public void removeProductsPage(AnchorPane pane) {
        Panel panel = new Panel();
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
        
        submit.setOnAction(e-> panel.deleteTheProduct(e, idField));
        
    }
    public void deleteTheProduct(ActionEvent e, TextField idField) {
        if(idField.getText().trim().equals("") && doThisIdExist(Integer.parseInt(idField.getText())) ) {
            System.out.println("Blad usuniecia konta o numerze " + idField.getText());
        } else {
            products.remove(Integer.parseInt(idField.getText()));
        }
    }
    
    public void submitTheForm(ActionEvent e, TextField productNameField, TextField widthNameField, TextField heightNameField, TextField priceNameField) {
        if(productNameField.getText().trim().equals("") || widthNameField.getText().trim().equals("") || heightNameField.getText().trim().equals("") || priceNameField.getText().trim().equals("")) {
            System.out.println("Błąd");
        } else {
            Convert convert = new Convert();
            System.out.println(products.size());

            if(!doThisProductExist(productNameField.getText(), convert.convertToInt(widthNameField.getText()), convert.convertToInt(heightNameField.getText()), convert.convertToDouble(priceNameField.getText()))) {
                products.add(new Product(generateProductIdNumber(products.size()),productNameField.getText(), convert.convertToInt(widthNameField.getText()), convert.convertToInt(heightNameField.getText()), convert.convertToDouble(priceNameField.getText())));
                System.out.println(products.get(products.size()-1).getType());
                System.out.println(products.size());
            }
        }
    }
    private boolean doThisProductExist(String productName, int width, int height, double price) {
        boolean toReturn = false;
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getType().equals(productName) && products.get(i).getWidth() == width && products.get(i).getPrice() == price) {
                toReturn = true;
                products.get(i).addSize(width*height/100);
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
    
    public void clearTheForm(ActionEvent e, TextField productNameField, TextField widthNameField, TextField heightNameField, TextField priceNameField) {
        productNameField.setText("");
        widthNameField.setText("");
        heightNameField.setText("");
        priceNameField.setText("");
    }
}
