package magazyn;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static magazyn.Warehouse.history;

public class HistoryPanel {
    
    public void historyOverview(AnchorPane pane) {
       TableView table = new TableView();
       table.setEditable(true);
       table.setMinWidth(1000);
       table.setMinHeight(600);
        
       TableColumn dateCol = new TableColumn("Data");
       dateCol.setMinWidth(200);
       dateCol.setCellValueFactory(
                new PropertyValueFactory<History, String>("date"));
       
       TableColumn contentCol = new TableColumn("Zawartość");
       contentCol.setMinWidth(800);
       contentCol.setCellValueFactory(
                new PropertyValueFactory<History, String>("content"));
       
       table.setItems(history);
       table.getColumns().addAll(dateCol, contentCol);
       pane.getChildren().add(table);
    }
}
