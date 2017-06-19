package magazyn;

import javafx.scene.control.Alert;

public class Convert {
    public Convert() {}
    public Integer convertToInt(String arg) {
        Integer value = 0;
        try {	
            value = Integer.parseInt(arg);
        } catch(Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Błąd przy dodawaniu");
            alert.setHeaderText("Wprowadziłeś zły typ danych, spróbuj ponownie");
            alert.showAndWait();
        }
        return value;
    }
    
    public Double convertToDouble(String arg) {
        Double value = 0.00;
        try {	
            value = Double.parseDouble(arg);
        } catch(Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Błąd przy dodawaniu");
            alert.setHeaderText("Wprowadziłeś zły typ danych, spróbuj ponownie");
            alert.showAndWait();
        }
        return value;
    }
}
