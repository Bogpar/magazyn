package magazyn;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;

public class Handler {
    public final Stage dialog = new Stage();
    public AnchorPane dialogVbox = new AnchorPane();
    public Scene dialogScene = new Scene(dialogVbox, 250, 125);
    public Button btn = new Button();
    public Button btn2 = new Button();
    
    Handler(Stage stage) {
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
    }
    
    public void permisionHandler() {
        
        
        btn.setText("Akceptuj");
        btn.setLayoutX(50);
        btn.setLayoutY(50);
        btn2.setText("Anuluj");
        btn2.setLayoutX(150);
        btn2.setLayoutY(50);
        
        dialogVbox.getChildren().add(btn);
        dialogVbox.getChildren().add(btn2);
        
        dialog.setScene(dialogScene);
        dialog.show();
        
    }
    
    public void errorHandler(String errMsg) {
        Text text = new Text(errMsg);
        text.setLayoutX(5);
        text.setLayoutY(30);
        
        btn2.setText("Rozumiem");
        btn2.setLayoutX(60);
        btn2.setLayoutY(50);
        
        dialogVbox.getChildren().add(text);
        dialogVbox.getChildren().add(btn2);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
